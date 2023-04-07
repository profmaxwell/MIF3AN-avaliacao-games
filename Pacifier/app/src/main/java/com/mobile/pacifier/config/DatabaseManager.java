package com.mobile.pacifier.config;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DB_NAME = "pacifier";
    private static final String DB_HOST = "pacifier.mssql.somee.com";
    private static final String DB_USER = "Abner_SQLLogin_1";
    private static final String DB_PASS = "jailcm6m1l";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Class.forName("net.sourceforge.jtds.jdbc.Driver");

        String jdbcUrl = "jdbc:jtds:sqlserver://" + DB_HOST + "/" + DB_NAME;
        return DriverManager.getConnection(jdbcUrl, DB_USER, DB_PASS);
    }
}
