package com.jlju.docmanager.service;


import org.junit.Test;


import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Created by zyz on 2016/11/24.
 */

public class MagazineServiceTest {




    @Test
    public void connTest() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/docmanager?useUnicode=true&characterEncoding=utf8", "root", "x5");
        System.out.println(conn.isClosed());
        conn.close();
    }
    private static void test(){
        String[] strings = new String [10];
    }
}