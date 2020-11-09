package com.abraham.dao;

import com.abraham.pojo.Department;
import com.abraham.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工 Dao
 * @author long
 * @date 2020/11/9
 */
@Repository
public class EmployeeDao {

    // 模拟数据库中员工表的数据
    static private Map<Integer, Employee> employees;

    // 自动注入
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();    //创建一个员工表
        employees.put(1001, new Employee(1001, "long", "1234@qq.com", 0, new Department(101, "技术部")));
        employees.put(1002, new Employee(1002, "abraham", "1345@qq.com", 0, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "xuan", "5665@qq.com", 1, new Department(103, "调研部")));
        employees.put(1004, new Employee(1004, "ying", "7688@qq.com", 0, new Department(104, "后勤部")));
        employees.put(1005, new Employee(1005, "xin", "8089@qq.com", 1, new Department(105, "运营部")));
    }


    /**
     * 主键自增
     */
    private static Integer initialID = 1006;

    /**
     * 增加一个员工
     * @param employee
     */
    public void addEmployee(Employee employee) {
        if (employee.getId() == null)
            employee.setId(initialID++);
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    /**
     * 查询全部员工信息
     * @return
     */
    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    /**
     * 通过id查询员工
     * @param id
     * @return
     */
    public Employee getEmployeeByID(Integer id) {
        return employees.get(id);
    }

    /**
     * 通过id删除员工
     * @param id
     */
    public void deleteEmployeeByID(int id) {
        employees.remove(id);
    }
}
