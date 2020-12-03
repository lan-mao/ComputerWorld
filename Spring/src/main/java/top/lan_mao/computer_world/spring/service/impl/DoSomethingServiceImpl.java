package top.lan_mao.computer_world.spring.service.impl;

import top.lan_mao.computer_world.spring.bean.Person;
import top.lan_mao.computer_world.spring.service.DoSomethingService;

/**
 * Create Date 2020/09/07 10:09
 * Created by lan-mao.top
 */
 
public class DoSomethingServiceImpl implements DoSomethingService {

    private String name;
    private int age;

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DoSomethingServiceImpl() {
        System.out.println("实例化中");
    }

    @Override
    public String doSomething() {
        System.out.println("doSomething方法运行");
        return "doSomething";
    }

    @Override
    public String doNothing() {
        System.out.println("doNothing方法运行");
        return "doNothing";
    }

    @Override
    public String doError() {
        return 1/0+"";
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DoSomethingServiceImpl{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", person=").append(person);
        sb.append('}');
        return sb.toString();
    }
}
