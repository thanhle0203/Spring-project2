package com.thanhle.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean {
    private int empId;
    private String name;
    private String designation;
    private int salary;

    public Employee() {

    }

    public Employee(int empId, String name, String designation, int salary) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void m1() {
        System.out.println("The init-method m1() invoked....");
    }

    public void destroy() {
        System.out.println("The destroy-method destroy() invoked...");
    }

    public void destroyMe() {
        System.out.println("The destroyMe() invoked...");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.salary = this.salary + 555;
        System.out.println("Employee: afterPropertiesSet() of Initializing bean invoked...");
    }
}
