package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeService employeeServiceImpl ;

    @GetMapping("/welcome")
    public ResponseEntity<String> sayWel(){

     return   ResponseEntity.ok("Welcome To Pune");
    }



    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Employee employee){
        employeeServiceImpl.signUp(employee);
        return ResponseEntity.ok("Signup Done Successfully");
    }


    @GetMapping("hey")
    public String sayHello(){
        return "Shashi";
    }
@PostMapping("/savabulkofdata")
    public ResponseEntity<String> saveBulkOfData(@RequestBody List<Employee> employees){
         employeeServiceImpl.saveBulkOfData(employees);
         return ResponseEntity.ok("Save All Data");


}
    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword) {
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId, empPassword));

    }
    @GetMapping("/getdatabyid/{empId}")
     public ResponseEntity<Employee> getDataById(@PathVariable int empId){
         return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }
    @GetMapping("/getalldata")
    public  ResponseEntity <List<Employee>> getAllData(){
         return ResponseEntity.ok(employeeServiceImpl.getAllData());

    }
    @GetMapping("/getdatabyname/{empName}")
    public  ResponseEntity<List<Employee>> getDataByName(@PathVariable String  empName){
   return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));

    }
    @GetMapping("/getdatabycontactnumber/{empContactNumber}")
    public ResponseEntity<Employee> getDataByContactnumber(@PathVariable long empContactNumber){
         return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(empContactNumber));

    }
    @GetMapping("/getdatabyemailid/{empEmailId}")
    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String empEmailId){
         return ResponseEntity.ok(employeeServiceImpl.getDataByEmailId(empEmailId));
    }
    @GetMapping ("/filterdatabysalary/{empSalary}")
     public ResponseEntity <List<Employee>> filterDataBySalary(@PathVariable double empSalary){
         return ResponseEntity.ok(employeeServiceImpl.filterDataBySalary(empSalary));
    }
    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName(){
         return ResponseEntity.ok(employeeServiceImpl.sortByName());
    }
}
