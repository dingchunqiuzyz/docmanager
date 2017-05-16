package com.jlju.docmanager.service;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Magazine;
import com.jlju.docmanager.bean.Users;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}