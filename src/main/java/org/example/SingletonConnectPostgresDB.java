package org.example;

public class SingletonConnectPostgresDB {

    private static ConnectToPostgresMyDB connectToPostgresMyDB;

    public static ConnectToPostgresMyDB getInstant() {
        if(connectToPostgresMyDB == null) {
            connectToPostgresMyDB = new ConnectToPostgresMyDB();
        }
        return connectToPostgresMyDB;
    }
}
