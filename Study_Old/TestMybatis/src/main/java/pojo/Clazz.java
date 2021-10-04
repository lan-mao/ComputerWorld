package pojo;

import java.util.Objects;

/**
 * Create Date 2020/03/03 21:43
 * Created by lan-mao.top
 */
 
public class Clazz {
    private Integer id;
    private String name;
    private String room;

    public Clazz() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz aClazz = (Clazz) o;
        return Objects.equals(id, aClazz.id) &&
                Objects.equals(name, aClazz.name) &&
                Objects.equals(room, aClazz.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, room);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Clazz{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", room='").append(room).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
