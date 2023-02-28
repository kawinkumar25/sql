package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;


class Dbconn {
    String username;
    String password;
    String database;
    Connection conn;
    static Dbconn firstobject = null;
    Logger l = Logger.getLogger("kawin");
    private Dbconn(String database, String username, String password) {
        this.database = database;
        this.username = username;
        this.password = password;
    }
    //database name: jdbc:mysql://localhost:3306/
    //password:12345678
    //username: root

    public static Dbconn in(String database, String username, String password) {
        if(firstobject==null)
        {
            firstobject=new Dbconn(database, username, password);
        }
        return firstobject;
    }

    void connection() {
        try {
            conn = DriverManager.getConnection(database, username, password);
            l.info("connection established");
        } catch (Exception e) {
            l.info(String.valueOf(e));
        }
    }

    void close() {
        try {
            conn.close();
            l.info("connection closed");
        } catch (Exception e) {
            l.info(String.valueOf(e));
        }
    }
}

