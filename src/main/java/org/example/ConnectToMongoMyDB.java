package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectToMongoMyDB {
    public static MongoCollection<Document> connect(){
        Properties properties = new Properties();
        try (InputStream input = ConnectToMongoMyDB.class.getClassLoader()
                .getResourceAsStream("authorization/authorizationMongoMyDB.properties")) {
            if (input == null) {
                throw new RuntimeException("Файл не найден в resources!");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String urlMongo = properties.getProperty("db.url");
        MongoClient mongoClient = MongoClients.create(urlMongo);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("DatabaseMongo");
        return mongoDatabase.getCollection("CollectionMongo");
    }
}
