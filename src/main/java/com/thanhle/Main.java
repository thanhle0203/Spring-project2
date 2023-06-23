package com.thanhle;

import com.thanhle.dao.EmployeeDao;
import com.thanhle.dao.EmployeeDao2;
import com.thanhle.domain.Employee;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        String[] beans = context.getBeanDefinitionNames();

        for (String beanName : beans) {
            System.out.println(beanName);
        }

        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");

        Employee e = new Employee(3, "Thanh Le", "Software Engineer", 100000);

        //employeeDao.save(e);
        //employeeDao.save2(e);
        //employeeDao.findAll();
        //employeeDao.findById(3);
        //employeeDao.updateById(3, "FullStack Engineer", 120000);
        //employeeDao.deleteById(3);
        //employeeDao.findEmployee(50000);

        System.out.println("================Using NamedParameterJdbcTemplate===============");
        EmployeeDao2 employeeDao2 = (EmployeeDao2)context.getBean("employeeDao2");
        employeeDao2.createEmplyee(new Employee(8, "Sai", "Programmer", 15099));


    }
}