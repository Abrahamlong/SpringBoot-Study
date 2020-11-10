package com.abraham;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class StudySpringbootApplicationTests {

    // 注入数据源
    @Autowired
    DataSource dataSource;



    @Test
    public void contextLoads() throws SQLException {
        // 查看默认数据源
        System.out.println(dataSource.getClass());
        // 获得MySQL数据库连接
        Connection connection =  dataSource.getConnection();
        System.out.println(connection);
        // 关闭连接
        connection.close();
    }

    @Test
    public void testDruid() throws SQLException {
        // 查看默认数据源
        System.out.println(dataSource.getClass());
        // 获得连接
        Connection connection =   dataSource.getConnection();
        System.out.println(connection);
        // 获得数据源连接数
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());
        // 关闭连接
        connection.close();
    }

    @Test
    public void testMyBatis() throws SQLException {
        // 查看默认数据源
        System.out.println("数据源 >>>>>> " + dataSource.getClass());
        // 获得连接
        Connection connection = dataSource.getConnection();
        System.out.println("连接 >>>>>> " + connection);
        System.out.println("连接地址 >>>>>> " + connection.getMetaData().getURL());
        // 连接关闭
        connection.close();
    }


}
