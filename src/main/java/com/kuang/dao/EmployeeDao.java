package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Map;

public class EmployeeDao {

    //模拟数据库中的值
    private  static Map<Integer, Employee> employees =  null;  //创建了一张表

    @Autowired
    private DepartmentDao departmentDao;

    static {

        employees.put(1001,new Employee(1001,"AA","1393786009@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","1393786009@qq.com",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","1393786009@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","1393786009@qq.com",0,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","1393786009@qq.com",0,new Department(105,"研发部")));

    }
    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //根据id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
    
}
