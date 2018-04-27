package tw.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
@Entity
@Table(name="Employee")
public class Employee {
    //字段名称与数据库字段名称一致

    @Id
 //   @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private String gender;

    public Employee() {}

    public Employee(Integer id,String name, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object e) {
        if (this == e) return true;
        if (e == null || getClass() != e.getClass()) return false;

        Employee employee = (Employee) e;

        if (id != employee.id) return false;
        return name.equals(employee.name)&&age.equals(employee.age)&&gender.equals(employee.gender);
    }
}
