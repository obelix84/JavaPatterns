package ru.gb.socialnet.db;

import lombok.ToString;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

@ToString
public final class DatabaseHandler implements DatabaseInterface {

    private static volatile DatabaseHandler dbh;

    private Connection connection;

    public DatabaseHandler() {
        String url = "jdbc:mysql://localhost:3306/socialnetwork";
        Properties props = new Properties();
        //ToDo
        //Так пароль хранить не надо, временное решение
        props.setProperty("user", "root");
        props.setProperty("password", "12345");
        props.setProperty("ssl", "false");
        try {
            this.connection = DriverManager.getConnection(url, props);
        } catch (SQLException th) {
            th.printStackTrace();
        }
    }

    public static DatabaseHandler getDbh() {
        DatabaseHandler result = dbh;
        if (result != null) {
            return result;
        }
        synchronized(DatabaseHandler.class) {
            if (dbh == null) {
                dbh = new DatabaseHandler();
            }
            return dbh;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        try {
            this.connection.close();
        } catch (SQLException th) {
            th.printStackTrace();
        }
    }
}

