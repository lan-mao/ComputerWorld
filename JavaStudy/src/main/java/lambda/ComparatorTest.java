package lambda;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Create Date 2020/09/15 16:31
 * Created by lan-mao.top
 * TODO 
 *  - 这是Comparator接口的lambda表达式测试
 */
 
public class ComparatorTest {

    static Person[] people = new Person[5];

    @BeforeAll
    static void beforeAll() {
        people[0] = new Person("Qdaing","Adian");
        people[1] = new Person("Jdaing","Adian");
        people[2] = new Person("Traing","dad");
        people[3] = new Person("Igina","ddd");
        people[4] = new Person("Adian","Adibaan");
    }

    @Test
    public void comparatorTest01() {
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        });
    }

    @Test
    public void comparatorTest02() {

        Arrays.sort(people, (s1,s2) -> s1.firstName.compareTo(s2.firstName));
    }
    @Test
    public void comparatorTest03() {

        //Arrays.sort(people, (s1,s2) -> s1.firstName.compareTo(s2.firstName));
        Arrays.sort(people, Comparator.comparing(s -> s.firstName));
    }
    @Test
    public void comparatorTest04() {
        /*Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        });*/
        //
        Arrays.sort(people, (s1,s2) -> Person.compareName(s1,s2));
    }

    @Test
    public void comparatorTest05() {
        Arrays.sort(people, Person::compareName);
    }

    @AfterAll
    static void sout() {
        System.out.println(Arrays.toString(people));
    }
}

class Person{
    String firstName;
    String secondName;

    public Person() {
    }

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName;
    }

    public static int compareName(Person p1, Person p2) {
        return p1.firstName.compareTo(p2.firstName);
    }

}