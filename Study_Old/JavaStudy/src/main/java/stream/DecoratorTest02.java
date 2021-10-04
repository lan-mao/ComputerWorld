package stream;

/**
 * @Classname DecoratorTest02
 * 装饰模式实验——服饰穿着
 * @Date 2020/02/05 10:57
 * @Created by lan-mao.top
 */

public class DecoratorTest02 {
    public static void main(String[] args) {
        Person person = new Person("小菜");
        person = new TShirt(person);
        person = new Shoes(person);
        person = new Necktie(person);
        System.out.println(person.show());
        //装扮-->小菜 T恤 皮鞋 领带
    }
}

//抽象组件
//因为只有一个类，不需要抽象出来
//具体组件
class Person {
    private String name ;

    protected Person() {
    }

    public Person(String name) {
        this.name = name;
    }
    public String show(){
        return "装扮-->" +name;
    }
}

//抽象装饰类
abstract class Finery extends Person{
    Person person ;

    public Finery(Person person) {
        this.person = person;
    }

    @Override
    public String show() {
        return person.show();
    }
}

//具体装饰类
class TShirt extends Finery {
    public TShirt(Person person) {
        super(person);
    }

    @Override
    public String show() {
        return super.show() + " T恤";
    }
}
class Necktie extends Finery {
    public Necktie(Person person) {
        super(person);
    }

    @Override
    public String show() {
        return super.show() + " 领带";
    }
}
class Shoes extends Finery {
    public Shoes(Person person) {
        super(person);
    }

    @Override
    public String show() {
        return super.show() + " 皮鞋";
    }
}