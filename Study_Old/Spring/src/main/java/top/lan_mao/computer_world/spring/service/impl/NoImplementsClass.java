package top.lan_mao.computer_world.spring.service.impl;

import top.lan_mao.computer_world.spring.bean.Person;

/**
 * Create Date 2020/09/08 17:50
 * Created by lan-mao.top
 *  - 一个没有接口的实现类
 */

public class NoImplementsClass {
    public String doSomething() {
        return "CHINA";
    }

    public Person returnNotString() {
        Person person = new Person();
        person.setName("aaa");
        person.setAge(12);
        return person;
    }
}