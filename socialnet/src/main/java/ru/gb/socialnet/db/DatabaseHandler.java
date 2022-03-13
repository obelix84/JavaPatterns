package ru.gb.socialnet.db;

import lombok.ToString;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@ToString
public final class DatabaseHandler {

    private static DatabaseHandler dbh;

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
            //тут будем хранить prepeared statements
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
}

