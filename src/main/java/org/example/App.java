package org.example;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World, i am Docker container!");

        ArrayList<User> newUsers = new ArrayList<>();
        newUsers.add(new User("Maria", "Mongodobova", "MongoTheBestDB1337@mail.ru"));
        newUsers.add(new User("Sergei", "Debomongov", "ForeverLoveMongoDB322@gmail.com"));

        ArrayList<Document> documentsUsers = new ArrayList<>();
        for (int i = 0; i < newUsers.size(); i++) {
            documentsUsers.add(new Document()
                    .append("_id", new ObjectId())
                    .append("name", newUsers.get(i).getName())
                    .append("last_name", newUsers.get(i).getLast_name())
                    .append("email", newUsers.get(i).getEmail()));
        }
        ConnectToMongoMyDB.connect().insertMany(documentsUsers);

    }
}