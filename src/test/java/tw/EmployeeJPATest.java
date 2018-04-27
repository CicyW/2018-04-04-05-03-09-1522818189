package tw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.transaction.annotation.Transactional;
import tw.entity.Employee;
import tw.repository.EmployeeRepository;

import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class EmployeeJPATest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void should_return_expected_employee_when_find_by_id()throws Exception{
        Employee expectedEmployee = new Employee(5,"小张",22,"female");
        employeeRepository.save(expectedEmployee);
        Employee actualEmployee = employeeRepository.findById(5);
        assert(expectedEmployee.equals(actualEmployee));
    }

    @Test
    public void should_return_expected_employee_when_find_by_name() throws Exception{
        Employee expectedEmployee = new Employee(5,"小吴",19,"male");
        employeeRepository.save(expectedEmployee);
        Employee actualEmployee = employeeRepository.findByName("小吴");
        assert(expectedEmployee.equals(actualEmployee));
    }

    @Test
    public void should_update_employee_name_when_update_employee_name_by_id() throws Exception{
        employeeRepository.save(new Employee(5,"小陈",20,"male"));
        int num = employeeRepository.updateNameById("小新",3);
        assertTrue(num==1);
    }

    @Test
    public void should_update_employee_gender_when_update_employee_gender_by_id() throws Exception{
        employeeRepository.save(new Employee(5,"小雷",20,"male"));
        int num = employeeRepository.updateGenderById("female",3);
        assertTrue(num==1);
    }

    @Test
    public void should_update_employee_age_when_update_employee_age_by_id() throws Exception{
        employeeRepository.save(new Employee(5,"小胡",20,"male"));
        int num = employeeRepository.updateAgeById(22,5);
        assertTrue(num==1);
    }

    @Test
    public void should_delete_employee_when_delete_employee_age_by_id() throws Exception{
        employeeRepository.save(new Employee(5,"小金",20,"male"));
        int num = employeeRepository.deleteEmployeeById(5);
        assertTrue(num==1);
    }

}
