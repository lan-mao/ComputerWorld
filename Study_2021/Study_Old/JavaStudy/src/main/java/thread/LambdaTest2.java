package thread;

/**
 * @Classname LambdaTest2
 * 测试Lambda表达式的使用方法
 * @Date 2020/02/07 20:47
 * @Created by lan-mao.top
 */

public class LambdaTest2 {
    public static void main(String[] args) {
        TestLambda0 test0 = ()->{
            System.out.println("无参数，无返回值");
        };
        // 只有一行代码,可以省略大括号{}
        TestLambda0 test1 = ()->System.out.println("无参数，无返回值，只有一行代码");
        //有参数时
        TestLambda1 test2 = (a) -> System.out.println(a);
        //只有一个参数时，可以省略小括号()
        TestLambda1 test3 = a -> System.out.println(a);
        //带返回值,可以省略形参的类型
        TestLambda2 test4 = (a,b) -> {
            System.out.println(a + "----" + b);
            return a+b;
        };
        //带返回值的方法，如果只有一行return语句，可以直接省略return关键字
        TestLambda2 test5 = (a,b) -> a+b;
    }
}
interface TestLambda0 {
    void test();
}
interface TestLambda1 {
    void test(int a);
}
interface TestLambda2 {
    int test (int a,int b);
}