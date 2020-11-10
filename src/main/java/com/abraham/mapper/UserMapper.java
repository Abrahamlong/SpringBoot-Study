package com.abraham.mapper;

import com.abraham.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author long
 * @date 2020/11/10
 */
// @Mapper: 表示本类是一个 MyBatis 的 Mapper，等价于以前 Spring 整合 MyBatis 时的 Mapper 接口
@Mapper
// 自动配置到springboot,表明该类为dao层的类
@Repository
public interface UserMapper {

    /**
     * 查询全部用户
     * @return
     */
    List<User> selectUser();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User selectUserById(int id);

    /**
     * 新增一个用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 修改一个用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteUser(int id);
}