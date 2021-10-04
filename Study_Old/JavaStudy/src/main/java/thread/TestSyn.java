package thread;

/**
 * @Classname TestSyn
 * 使用同步方法、同步方法块
 * @Date 2020/02/08 15:21
 * @Created by lan-mao.top
 */

public class TestSyn {
    public static void main(String[] args) {
        Account account = new Account("123456",10000);
        SynDrawMoney person1 = new SynDrawMoney(account, "NO1", 3000);
        SynDrawMoney person2 = new SynDrawMoney(account, "NO2", 8000);
        new Thread(person1).start();
        new Thread(person2).start();
    }
}
class Account{
    String name ;
    int balance;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
}
class SynDrawMoney implements Runnable{

    Account account; //取款账户
    String personName; //取款人
    int money; //取出钱数

    public SynDrawMoney(Account account, String personName,int money) {
        this.account = account;
        this.personName = personName;
        this.money = money;
    }

    public synchronized void drawMoney(){

        if (account.balance < money) {
            System.out.println(String.format("取款人：%s,账户%s余额为：%d。余额不足取出%d",personName, account.name, account.balance, money));
            return;
        }
        try {
            Thread.sleep(1000);
            account.balance -= money;
            System.out.println(String.format("取款人：%s 从 %s 中取出 %d。剩余余额：%d", personName, account.name, money, account.balance));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        drawMoney();
    }
}