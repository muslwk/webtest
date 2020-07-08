package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    /*
        URL USER PASSWORD DRIVER
     */
    private static final String URL="jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "takagi1207";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    //获取连接
    private static Connection conn;

    static {
        try {
            //加载驱动
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        return conn;
    }

}
