package tw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tw.entity.Employee;
import tw.service.EmployeeService;
import tw.constant.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/createOneEmployee")
    @ResponseBody
    public Map<String,Object> createOneEmployee(@RequestParam(required=true)Integer id,
                                         @RequestParam(required=true)String name,
                                         @RequestParam(required=true)Integer age,
                                         @RequestParam(required=true)String gender) {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            map.put("status",Constants.SUCCESS);
            if(employeeService.saveOneEmployee(id,name,age,gender)){
                map.put("message","增加成功");
            }else {
                map.put("message","增加失败，该id已存在！");
            }
        }catch (Exception ex){
            map.put("status",Constants.FAILE);
        }
        return map;
    }

    @RequestMapping("/employees")
    @ResponseBody
    public List<Employee> readAllEmployees() {
        Map<String,Object> map = new HashMap<String, Object>();
        return employeeService.findAllEmployees();
    }

    @RequestMapping("/readEmployeeById")
    @ResponseBody
    public Employee readEmployeeById(@RequestParam(required=true)Integer id) {
        Map<String,Object> map = new HashMap<String, Object>();
        return employeeService.findEmployeeById(id);
    }

    @RequestMapping("/readEmployeeByName")
    @ResponseBody
    public Employee readEmployeesByName(@RequestParam(required=true)String name) {
        Map<String,Object> map = new HashMap<String, Object>();
        return employeeService.findEmployeesByName(name);
    }

    @RequestMapping("/readEmployeesByGender")
    @ResponseBody
    public List<Employee> readEmployeesByGender(@RequestParam(required=true)String gender) {
        Map<String,Object> map = new HashMap<String, Object>();
        return employeeService.findEmployeesByGender(gender);
    }

    @RequestMapping("/updateEmployeeNameById")
    @ResponseBody
    public Map<String,Object> updateEmployeeNameById(@RequestParam(required=true)String name,
                                                     @RequestParam(required=true)Integer id) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("status",employeeService.updateNameById(name,id)?Constants.SUCCESS:Constants.FAILE);
        return map;
    }

    @RequestMapping("/updateEmployeeGenderById")
    @ResponseBody
    public Map<String,Object> updateEmployeeGenderById(@RequestParam(required=true)String gender,
                                                     @RequestParam(required=true)Integer id) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("status",employeeService.updateGenderById(gender,id)?Constants.SUCCESS:Constants.FAILE);
        return map;
    }

    @RequestMapping("/updateEmployeeAgeById")
    @ResponseBody
    public Map<String,Object> updateEmployeeAgeById(@RequestParam(required=true)Integer age,
                                                       @RequestParam(required=true)Integer id) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("status",employeeService.updateAgeById(age,id)?Constants.SUCCESS:Constants.FAILE);
        return map;
    }

    @RequestMapping("/deleteEmployeeById")
    @ResponseBody
    public Map<String,Object> deleteEmployeeById(@RequestParam(required=true)Integer id) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("status",employeeService.deleteEmployeeById(id)?Constants.SUCCESS:Constants.FAILE);
        return map;
    }
}