package com.csi.service;


import com.csi.Dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDaoImpl;

    @Override
    public void signUp(Employee employee) {
        employeeDaoImpl.signUp(employee);
    }

    @Override
    public void saveBulkOfData(List<Employee> employees) {
        employeeDaoImpl.saveBulkOfData(employees);

    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        return employeeDaoImpl.signIn(empEmailId, empPassword);
    }

    @Override
    public List<Employee> getAllData() {

        return employeeDaoImpl.getAllData();
    }

    @Override
    public Employee getDataById(int empId)
    {
        return employeeDaoImpl.getDataById(empId);
    }

    @Override
    public List<Employee> getDataByName(String empName) {
        return employeeDaoImpl.getDataByName(empName);
    }

    @Override
    public Employee getDataByContactNumber(long empContactNumber) {
        return employeeDaoImpl.getDataByContactNumber(empContactNumber);
    }

    @Override
    public Employee getDataByEmailId(String empEmailId) {

        return employeeDaoImpl.getDataByEmailId(empEmailId);
    }

    @Override
    public List<Employee> filterDataBySalary(double empsalary) {

        return employeeDaoImpl.filterDataBySalary(empsalary);
    }

    @Override
    public List<Employee> sortByName() {
        return employeeDaoImpl.sortByName();
    }






}
