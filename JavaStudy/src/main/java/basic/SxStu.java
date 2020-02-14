package basic;

public class SxStu {
    int id;
    String name;
    int age;

    Computer computer ;

    void study(){
        System.out.println("我在认真学习！！" + computer.band);
    }

    void play(){
        System.out.println("我在玩游戏！王者荣耀！");
    }

    public static void main(String[] args) {
        SxStu stu = new SxStu();
        stu.id = 1000;
        stu.name = "ma";
        stu.age = 18;

        Computer computer = new Computer();
        computer.band = "lenovo";
        stu.computer = computer;
        stu.study();
    }
}

class Computer{
    String band;
}