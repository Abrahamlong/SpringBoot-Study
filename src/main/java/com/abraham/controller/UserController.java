package com.abraham.controller;

import com.abraham.mapper.UserMapper;
import com.abraham.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author long
 * @date 2020/11/10
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // 选择全部用户
    @GetMapping("/selectUser")
    public String selectUser(){
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
        return "selectUser-ok";
    }

    // 根据id选择用户
    @GetMapping("/selectUserById")
    public String selectUserById(){
        User user = userMapper.selectUserById(1);
        System.out.println(user);
        return "selectUserById-ok";
    }

    // 添加一个用户
    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(5,"阿毛","456789"));
        return "addUser-ok";
    }

    // 修改一个用户
    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(5,"阿毛","421319"));
        return "updateUser-ok";
    }

    // 根据id删除用户
    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(5);
        return "deleteUser-ok";
    }
}