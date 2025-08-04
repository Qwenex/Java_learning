package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConnectToPostgresMyDB {

    String url;
    String user;
    String password;

    public void connect() throws IOException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();

        try (InputStream input = Files.newInputStream(Paths.get(
                "C:\\Users\\Qwenex\\IdeaProjects\\Java_learning\\src\\main\\resources\\authorization\\authorizationPostgresMyDB.properties"))) {
            properties.load(input);
            this.url = properties.getProperty("db.url");
            this.user = properties.getProperty("db.user");
            this.password = properties.getProperty("db.password");
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
