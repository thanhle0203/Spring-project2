package com.thanhle.dao;

import com.thanhle.domain.Employee;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class EmployeeDaoImpl2 implements EmployeeDao2{
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Override
    public void createEmplyee(Employee e) {
        System.out.println("employee object to be persisted: " + e);
        String sql = "insert into employee(empId, name, designation, salary) values(:empId, :name, :designation, :salary )";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("empId", e.getEmpId());
        parameterSource.addValue("name", e.getName());
        parameterSource.addValue("designation", e.getDesignation());
        parameterSource.addValue("salary", e.getSalary());

        int update = namedParameterJdbcTemplate.update(sql, parameterSource);
        if (update == 1) {
            System.out.println("employee record created for " + e.getName() + ".");
        }
    }

    @Override
    public Employee getEmployeeByEmpId(int empId) {
        return null;
    }

    @Override
    public Employee getEmployeeByEmpId2(int empId) {
        return null;
    }

    @Override
    public String getEmployeeNameByEmpId3(int empId) {
        return null;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return null;
    }

    @Override
    public void updateEmployeeByEmpId(int empId, String designation, int salary) {

    }

    @Override
    public void deleteEmployeeByEmpId(int empId) {

    }
}
