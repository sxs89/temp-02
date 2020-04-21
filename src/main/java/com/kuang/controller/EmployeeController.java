package com.kuang.controller;

import com.kuang.dao.DepartmentDao;
import com.kuang.dao.EmployeeDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/emp")
    public String toAddEmployee(Model model){
        //查询所有的部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("demp",departments);
        return "/emp/employeeAdd";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee,Model model){
        //添加的操作
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    //去员工的修改页面
    @GetMapping("/toUpdateEmp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model){
        //查出原来的数据
        Employee emp = employeeDao.getEmployeeById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp",emp);
        model.addAttribute("dep",departments);
        return "/emp/employeeEdit";
    }

    //员工信息修改
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/deleteEmp/{id}")
    public String deleteId(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
