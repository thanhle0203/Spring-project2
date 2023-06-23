package com.thanhle.dao;

import com.thanhle.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee e);

    List<Employee> findAll();

    Employee findById(int empId);

    int updateById(int empId, String designation, int salary);

    void deleteById(int empId);

    void save2(Employee e);

    List<Employee> findEmployee(int target_salary);
}
