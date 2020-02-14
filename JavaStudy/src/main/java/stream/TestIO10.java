package stream;

import java.io.*;
import java.util.Date;

/**
 * @Classname TestIO10
 * 测试序列化与反序列化
 * @Date 2020/02/06 8:43
 * @Created by lan-mao.top
 */

public class TestIO10 {
    public static void main(String[] args) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("object")));            ){
            Test no1 = new Test("test", 200, new Date(), 10294393848494l);
            outputStream.writeObject(no1);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("object")))){
            Object o = inputStream.readObject();
            if (o instanceof Test){
                Test no2 = (Test)o;
                System.out.println(no2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static class Test implements Serializable{
        private transient String name ;
        private int salary;
        private Date createDate;
        private long id;

        public Test() {
        }

        public Test(String name, int salary, Date createDate, long id) {
            this.name = name;
            this.salary = salary;
            this.createDate = createDate;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Test{");
            sb.append("name='").append(name).append('\'');
            sb.append(", salary=").append(salary);
            sb.append(", createDate=").append(createDate);
            sb.append(", id=").append(id);
            sb.append('}');
            return sb.toString();
        }
    }
}
