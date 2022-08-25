package com.csi.Dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    private  static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

        @Override
    public void signUp(Employee employee) {
            Session session = factory .openSession();
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();

    }

    @Override
    public void saveBulkOfData(List<Employee> employees) {
            Session session = factory.openSession();
            for (Employee employee : employees){
                Transaction transaction = session .beginTransaction();
                session.save(employee);
                transaction.commit();
            }


    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
            Session session = factory.openSession();
            boolean flag =false;
            for (Employee emp :getAllData()){
                if (emp.getEmpEmailId().equals(empEmailId) && emp.getEmpPassWord().equals(empPassword)){
                    flag =true;
                }
            }

            return flag;
    }

    @Override
    public Employee getDataById(int empId) {
            Session session = factory.openSession();
            Employee employee = (Employee) session.get(Employee.class,empId);
        return employee;
    }


    @Override
    public List<Employee> getAllData() {
         Session session = factory.openSession();
         List<Employee> employeeList = session.createQuery("from Employee").list();
            return employeeList;
    }

    @Override
    public List<Employee> getDataByName(String empName) {
            Session sesion = factory.openSession();
            List<Employee> employeeList = new ArrayList<>();
            for (Employee  emp :getAllData()){
            if (emp.getEmpName().equals(empName)){
                employeeList.add(emp);
            }

            }

            return employeeList;
    }

    @Override
    public Employee getDataByContactNumber(long empContactNumber) {

        Employee emp= null;
        for (Employee employee : getAllData()) {

            if (employee.getEmpContactNumber() == empContactNumber) {
                emp = employee;
            }


        }
        return emp;
    }
    @Override
    public Employee getDataByEmailId(String empEmailId) {
        Employee emp=null;

        for(Employee employee: getAllData()){
            if(employee.getEmpEmailId().equals(empEmailId)){
                emp = employee;
            }
        }
        return emp;
    }



    @Override
    public List<Employee> filterDataBySalary(double empsalary) {
        return getAllData().stream().filter(emp->emp.getEmpSalary()>=empsalary).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByName() {
        return getAllData().stream().sorted((e1,e2)-> e1.getEmpName().compareTo(e2.getEmpName())).collect(Collectors.toList());
    }


}
