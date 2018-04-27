package tw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.entity.Employee;
import tw.repository.EmployeeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean saveOneEmployee(Integer id,String name,Integer age,String gemder)throws Exception{
        if(employeeRepository.findById(id)!=null) {
            return false;
        }else {
            Employee employee = new Employee(id,name,age,gemder);
            employeeRepository.save(employee);
            return true;
        }
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }

    public Employee findEmployeesByName(String name){
        return employeeRepository.findByName(name);
    }

    public List<Employee> findEmployeesByGender(String gender){
        return employeeRepository.findByGender(gender);
    }

    public boolean updateNameById(String name,Integer id){
        return employeeRepository.updateNameById(name,id)==1?true:false;
    }

    public boolean updateGenderById(String gender,Integer id){
        return employeeRepository.updateGenderById(gender,id)==1?true:false;
    }

    public boolean updateAgeById(Integer age,Integer id){
        return employeeRepository.updateAgeById(age,id)==1?true:false;
    }

    public boolean deleteEmployeeById(Integer id){
        return employeeRepository.deleteEmployeeById(id)==1?true:false;
    }

}

