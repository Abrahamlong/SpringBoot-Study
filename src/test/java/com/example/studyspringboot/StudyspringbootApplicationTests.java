package com.example.studyspringboot;

import com.example.studyspringboot.pojo.Dog;
import com.example.studyspringboot.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyspringbootApplicationTests {

    @Autowired
    private Dog dog;
    @Autowired
    private Person ps;
    @Test
    void contextLoads() {
        System.out.println(dog);
        System.out.println(ps);
    }

}
