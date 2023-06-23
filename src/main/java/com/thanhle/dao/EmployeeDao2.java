package com.thanhle.dao;

import com.thanhle.domain.Employee;

import java.util.List;

public interface EmployeeDao2 {
    void createEmplyee(Employee e);
    Employee getEmployeeByEmpId(int empId);
    Employee getEmployeeByEmpId2(int empId);
    String getEmployeeNameByEmpId3(int empId);

    List<Employee> findAllEmployees();
    void updateEmployeeByEmpId(int empId, String designation, int salary);
    void deleteEmployeeByEmpId(int empId);
}
