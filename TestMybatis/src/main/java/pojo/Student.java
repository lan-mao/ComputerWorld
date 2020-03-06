package pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Create Date 2020/03/03 21:09
 * Created by lan-mao.top
 * TODO 
 *  - Student表的实体类
 */
 
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Integer cid;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(age, student.age) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(cid, student.cid) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex, cid);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", cid=").append(cid);
        sb.append('}');
        return sb.toString();
    }
}
