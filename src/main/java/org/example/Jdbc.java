package org.example;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {
    public static void main(String[] args) {
        String username;
        String password;
        String database;

        Scanner inp = new Scanner(System.in);
        System.out.println("Enter database name:");
        database = inp.next();
        System.out.println("Enter username:");
        username = inp.next();
        System.out.println("Enter password:");
        password = inp.next();

        Dbconn ob1 = Dbconn.in(database, username, password);

        boolean loop = true;
        while (loop) {
            System.out.println("1.connection estabilished\n2.connection close\n3.exit");
            int ch = inp.nextInt();
            if (ch == 1) {
                ob1.connection();
            } else if (ch == 2) {
                ob1.close();
            } else if (ch == 3) {
                loop = false;
                System.out.println("Exited");
            } else {
                System.out.println("choice incorrect");
            }
        }
    }
}

 class Dbconn {
    String username;
    String password;
    String database;
    Connection conn;

    private Dbconn(String database, String username, String password) {
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public static Dbconn in(String database, String username, String password) {
        return new Dbconn(database, username, password);
    }

    void connection() {
        try {
            conn = DriverManager.getConnection(database, username, password);
            System.out.println("connection established");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void close() {
        try {
            conn.close();
            System.out.println("connection closed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

