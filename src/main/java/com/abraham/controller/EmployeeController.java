package com.abraham.controller;


import com.abraham.dao.DepartmentDao;
import com.abraham.dao.EmployeeDao;
import com.abraham.pojo.Department;
import com.abraham.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author long
 * @date 2020/11/9
 */
@Controller
public class EmployeeController {

    @Autowired
    public EmployeeDao employeeDao;

    @Autowired
    public DepartmentDao departmentDao;

    @RequestMapping("/employees")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAllEmployees();
        model.addAttribute("employees",employees);
        return "employee/list";//返回到list页面
    }

    @GetMapping("/add")
    public String add(Model model) {
        // 查出所有的部门信息,添加到departments中,用于前端接收
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "employee/add";//返回到添加员工页面
    }

    @PostMapping("/save")
    public String save(Employee employee) {
        System.out.println(employee);
        employeeDao.addEmployee(employee);
        return "redirect:/employees";//返回到添加员工页面
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        // 查出原来的数据
        Employee employee = employeeDao.getEmployeeByID(id);
        model.addAttribute("employee",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "employee/update";//返回到添加员工页面
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(Employee employee) {
        System.out.println(employee);
        employeeDao.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.deleteEmployeeByID(id);
        return "redirect:/employees";
    }
}