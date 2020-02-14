package stream;

/**
 * @Classname DecoratorTest01
 * 装饰设计模式实验——咖啡
 *  - 抽象组件：需要装饰的抽象对象（接口或抽象父类）
 *  - 具体组件：需要装饰的对象
 *  - 抽象装饰类：包含对抽象组件的引用和装饰共有的方法
 *  - 具体装饰类：对需要装饰的组件进行装饰
 * @Date 2020/02/05 10:01
 * @Created by lan-mao.top
 */

public class DecoratorTest01 {
    public static void main(String[] args) {
        
        //我们可以逐个向其中添加配料，也可以直接加入已添加配料的饮料
        Drink drink = new Coffee();
        Drink sugar = new Sugar(drink);
        Drink milk = new Milk(drink);
        System.out.println(sugar.cost() + "----->" + sugar.info());
        System.out.println(milk.cost() + "----->" + milk.info());
        drink = new Milk(sugar);
        System.out.println(drink.cost() + "----->" + drink.info());
    }
}

//抽象组件
interface Drink{
    /**
     * @return 花费金额
     */
    int cost();

    /**
     * @return 费用信息
     */
    String info();
}

//具体组件
class Coffee implements Drink{
    String name = "原味咖啡";

    @Override
    public int cost() {
        return 5;
    }

    @Override
    public String info() {
        return name;
    }
}

//抽象装饰类
abstract class Batching implements Drink{
    // 对抽象组件的引用
    private Drink drink;
    public Batching (Drink drink){
        this.drink= drink;
    }

    @Override
    public int cost() {
        return drink.cost();
    }

    @Override
    public String info() {
        return drink.info();
    }
}

//具体装饰类
class Milk extends Batching {
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public int cost() {
        return super.cost() + 5;
    }

    @Override
    public String info() {
        return super.info() + " 牛奶";
    }
}

class Sugar extends Batching {
    public Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }

    @Override
    public String info() {
        return super.info() + " 单份糖";
    }
}