package org.example;

import java.util.Scanner;

import java.util.logging.Logger;

public class Jdbc {
    public static void main(String[] args) {
        String username;
        String password;
        String database;

        Logger l = Logger.getLogger("kawin");

        Scanner inp = new Scanner(System.in);
        l.info("Enter database name:");
        database = inp.next();
        l.info("Enter username:");
        username = inp.next();
        l.info("Enter password:");
        password = inp.next();

        Dbconn dbconnobj = Dbconn.in(database, username, password);


        boolean loop = true;
        while (loop) {
            l.info("1.connection estabilished\n2.connection close\n3.exit");
            int ch = inp.nextInt();
            if (ch == 1) {
                dbconnobj.connection();
            } else if (ch == 2) {
                dbconnobj.close();
            } else if (ch == 3) {
                loop = false;
                l.info("Exited");
            } else {
                l.info("choice incorrect");
            }
        }
    }
}

