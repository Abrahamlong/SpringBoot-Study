package com.abraham;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 本身就是一个spring的一个组件，程序主入口
@SpringBootApplication
//@MapperScan("com.abraham.mapper") // Mapper文件扫描
public class StudySpringbootApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudySpringbootApplication.class, args);
    }

}
