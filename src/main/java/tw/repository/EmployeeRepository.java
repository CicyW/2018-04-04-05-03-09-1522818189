package tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tw.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    Employee findById(Integer id);

    Employee findByName(String name);

    List<Employee> findByGender(String gender);

    @Modifying
    @Transactional
    @Query("update Employee e set e.name =?1 where e.id =?2")
    int updateNameById(String name,Integer id);

    @Modifying
    @Transactional
    @Query("update Employee e set e.gender =?1 where e.id =?2")
    int updateGenderById(String gender,Integer id);

    @Modifying
    @Transactional
    @Query("update Employee e set e.age =?1 where e.id =?2")
    int updateAgeById(Integer age,Integer id);

    @Modifying
    @Transactional
    @Query("delete from Employee e where e.id =?1")
    int deleteEmployeeById(Integer id);
}
