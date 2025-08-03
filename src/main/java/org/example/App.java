package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    /**
     * Получение данных из базы данных SQL
     * @param sql         SQL запрос
     * @param functionSql Функц. интерфейс для вывода столбцов БД
     * @param <T>         Тип данных записываемый в массив
     * @return Массив запрашиваемых данных в формате ArrayList
     */
    public static <T> ArrayList<T> getDataDB(String sql, FunctionSql<T> functionSql) throws SQLException, ClassNotFoundException {
        ArrayList<T> dataDBArray = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        String url ="jdbc:postgresql://localhost:5432/mydbpostgres";
        String user = "postgres";
        String password = "postgres";

        try (Connection connection = DriverManager.getConnection(url,user,password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                T object = functionSql.getData(resultSet);
                dataDBArray.add(object);
            }
        }
        return dataDBArray;
    }

    /**
     * Добавление новых данных через sql запрос
     * @param sql Sql запрос
     */
    public static void setDataDB(String sql) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url ="jdbc:postgresql://localhost:5432/mydbpostgres";
        String user = "postgres";
        String password = "postgres";
        try ( Connection connection = DriverManager.getConnection(url,user,password);
              Statement statement = connection.createStatement())
              {
            Integer rows = statement.executeUpdate(sql);
            logger.info("Было добавлено {} строк", rows);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        logger.info("Задание 1 SQL");
        // Добавление новых данных в БД
        ArrayList<User> newUsers = new ArrayList<>();
        newUsers.add(new User(10, "Maksim", "Volodilov","8793450123@gmail.com"));
        newUsers.add(new User(11, "Andrey", "Svetohodec","Andrushka07@gmail.com"));
        newUsers.add(new User(12, "Marina", "Valentinovna","sexygril2001@mail.ru"));
        newUsers.add(new User(13, "Yana", "Reznova","yanchik1999@gmail.com"));

        for (int i = 0; i < newUsers.size(); i++) {
            String sqlInsert = String.format("INSERT INTO users (id, first_name, last_name, email) VALUES (%s, '%s', '%s','%s')",
                    newUsers.get(i).getId(), newUsers.get(i).getName(), newUsers.get(i).getLast_name(), newUsers.get(i).getEmail());
            setDataDB(sqlInsert);
        }

        // Получение данных из БД
        ArrayList<User> allUsers = getDataDB("SELECT * FROM users ORDER BY id",
                resultSet -> new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));

        ArrayList<User> idAndGmails = getDataDB("SELECT id, email FROM users WHERE email LIKE '%@gmail.com'",
                resultSet -> new User(
                        resultSet.getInt("id"),
                        "",
                        "",
                        resultSet.getString("email")
                ));

        logger.info(allUsers.toString());
        logger.info(idAndGmails.toString());

        logger.info("Задание 2 NoSQL");
        String urlMongo = "mongodb://localhost:27017/";
        MongoClient mongoClient = MongoClients.create(urlMongo);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("DatabaseMongo");
        MongoCollection<Document> collection = mongoDatabase.getCollection("CollectionMongo");

        //Добавление записей в БД Mongo

        ArrayList<Document> documentsUsers = new ArrayList<>();
        for (int i = 0; i <= allUsers.size(); i++) {
        documentsUsers.add(new Document()
                .append("_id", allUsers.get(i).getId())
                .append("name", allUsers.get(i).getName())
                .append("last_name", allUsers.get(i).getLast_name())
                .append("email", allUsers.get(i).getEmail()));
        }
        collection.insertMany(documentsUsers);

        // Получение записей из БД Mongo
        ArrayList<User> usersFromMongoDB = new ArrayList<>();
        FindIterable<Document> documents = collection.find();
        documents.forEach(document -> usersFromMongoDB.add(
                new User(
                        document.getInteger("_id"),
                        document.getString("name"),
                        document.getString("last_name"),
                        document.getString("email")
                )
        ));
        logger.info(usersFromMongoDB.toString());
    }
}