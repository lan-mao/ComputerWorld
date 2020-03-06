package pojo;

import java.util.Objects;

/**
 * Create Date 2020/03/03 21:49
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public class StudentContainClass {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Integer cid;
    private Clazz clazz;

    public StudentContainClass() {
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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentContainClass that = (StudentContainClass) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(cid, that.cid) &&
                Objects.equals(clazz, that.clazz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex, cid, clazz);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentContainClass{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", cid=").append(cid);
        sb.append(", clazz=").append(clazz);
        sb.append('}');
        return sb.toString();
    }
}
