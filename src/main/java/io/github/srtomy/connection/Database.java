package io.github.srtomy.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static Database instance;

    private Connection conn;

    private Database() {
        try {
            conn = DriverManager.getConnection("jdbc:h2:./db", "sa", "");
        } catch (Exception ex) {
            System.out.printf("erro ao conectar com o banco, err:%s", ex);
            System.exit(1);
        }

    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }
}
