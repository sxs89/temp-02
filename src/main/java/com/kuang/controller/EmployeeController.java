package com.kuang.controller;

import com.kuang.dao.DepartmentDao;
import com.kuang.dao.EmployeeDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    //跳转员工列表界面
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);

        return "emp/employeeList";
    }

    @GetMapping("/toEmp")
    public String toAddEmployee(Model model){
        //查询所有的部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("demp",departments);
        return "/emp/employeeAdd";
    }

}
