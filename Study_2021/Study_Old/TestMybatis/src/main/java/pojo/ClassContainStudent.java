package pojo;

import java.util.List;
import java.util.Objects;

/**
 * Create Date 2020/03/04 9:20
 * Created by lan-mao.top
 */
 
public class ClassContainStudent {
    private Integer id;
    private String name;
    private String room;
    private List<Student> students;

    public ClassContainStudent() {
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassContainStudent that = (ClassContainStudent) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(room, that.room) &&
                Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, room, students);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClassContainStudent{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", room='").append(room).append('\'');
        sb.append(", students=").append(students);
        sb.append('}');
        return sb.toString();
    }
}
