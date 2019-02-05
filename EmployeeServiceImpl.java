package com.infosys.service;
//Import statements
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
       @Autowired
      EmployeeDAO employeeDao;
      public void insertEmployee(Employee emp) { 
           employeeDao.insert(emp); 
      }
      public int removeEmployee(int empId) { 
           return employeeDao.delete(empId); 
      }
}
