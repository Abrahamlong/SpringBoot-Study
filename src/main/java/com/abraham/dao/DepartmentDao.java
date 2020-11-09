package com.abraham.dao;

import com.abraham.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 部门 Dao
 * @author long
 * @date 2020/11/9
 */
@Repository
public class DepartmentDao {

    // 模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();  //创建一个部门表
        departments.put(101, new Department(101, "技术部"));
        departments.put(102, new Department(102, "市场部"));
        departments.put(103, new Department(103, "调研部"));
        departments.put(104, new Department(104, "后勤部"));
        departments.put(105, new Department(105, "运营部"));
    }

    /**
     * 获得部门的所有信息
     * @return
     */
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    /**
     * 通过id得到部门
     * @param id
     * @return
     */
    public Department getDepartmentById(int id) {
        return departments.get(id);
    }
}
