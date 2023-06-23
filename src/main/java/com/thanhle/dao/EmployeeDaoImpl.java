package com.thanhle.dao;

import com.thanhle.domain.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Employee e) {
        String sql = "insert into springdb.employee(empId, name, designation, salary) values(?, ?, ?, ?)";
        System.out.println("sql: " + sql);
        int recordsInserted = jdbcTemplate.update(sql, new Object[] {e.getEmpId(), e.getName(), e.getDesignation(), e.getSalary()});
        System.out.println("jdbcTemplate: " + jdbcTemplate);
        System.out.println("recordsInserted: " + recordsInserted);
    }

    @Override
    public List<Employee> findAll() {
        String query = "select * from employee";
        List<Employee> listOfEmployee = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Employee.class));
        for (Employee e : listOfEmployee) {
            System.out.println(e);
        }
        return listOfEmployee;
    }

    @Override
    public Employee findById(int empId) {
        String query = "select * from employee where empId=?";
        Employee retrivedEmployee = jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Employee.class), empId);
        System.out.println("retrievedEmployee: " + retrivedEmployee);

        return retrivedEmployee;
    }

    @Override
    public int updateById(int empId, String designation, int salary) {
        String query = "update employee set designation=?, salary=? where empId=?";

        int recordsUpdated = jdbcTemplate.update(query, new Object[]{designation, salary, empId});
        System.out.println("Records Updated: " + recordsUpdated);

        return recordsUpdated;
    }

    @Override
    public void deleteById(int empId) {
        String query = "delete from employee where empId=?";
        int recordsDeleted = jdbcTemplate.update(query, new Object[] {empId});
        System.out.println("Records deleted: " + recordsDeleted);
    }

    @Override
    public void save2(Employee e) {
        String sql = "insert into springdb.employee(empId, name, designation, salary) values ("
                + e.getEmpId() + ", '"+e.getName() +"', '"+e.getDesignation()+"', "+e.getSalary() +")";

        System.out.println("sql: " + sql);

        int recordsInserted = jdbcTemplate.update(sql);

        System.out.println("recordsInserted: " + recordsInserted);
    }

    @Override
    public List<Employee> findEmployee(int target_salary) {
        String query = "SELECT * FROM employee WHERE salary > ?";

        List<Employee> listOfEmployee = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Employee.class), target_salary);

        for (Employee e : listOfEmployee) {
            System.out.println(e);
        }

        return listOfEmployee;

    }

}
