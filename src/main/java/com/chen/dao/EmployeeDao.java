package com.chen.dao;

import com.chen.pojo.Department;
import com.chen.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 员工dao
@Repository
public class EmployeeDao {
    // 模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    // 员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer,Employee>(); // 创建一个员工表

        employees.put(1011,new Employee(1011,"Hooxi","weifengchen198@gmail.com",1,new Department(101,"igl")));
        employees.put(1012,new Employee(1012,"Niko","weifengchen198@gmail.com",1,new Department(102,"突破手")));
        employees.put(1013,new Employee(1013,"JKS","weifengchen198@gmail.com",1,new Department(105,"突破手")));
        employees.put(1014,new Employee(1014,"monsey","weifengchen198@gmail.com",1,new Department(103,"狙击手")));
        employees.put(1015,new Employee(1015,"hunter","weifengchen198@gmail.com",1,new Department(104,"自由人")));
    }

    // 主键自增
    private static Integer initId = 1016;
    // 增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    // 查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    // 删除员工通过id
    public void delete(Integer id){
        employees.remove(id);
    }
}
