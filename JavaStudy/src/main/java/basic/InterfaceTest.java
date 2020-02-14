package basic;

public interface InterfaceTest {
    public static void method1(){
        System.out.println("接口静态方法私有");
    }
}
class OutterClass {

     static class Inner{
        int a = 0;//非静态变量
        static int b = 0;//静态变量【报错！！】
        static final int c = 0;//编译期常量，不需要类加载
        static final Integer d = 1;//非编译期常量，需要类加载【报错！！】
    }

    public static void main(String[] args) {
        System.out.println(OutterClass.Inner.b);
        System.out.println(OutterClass.Inner.c);
        System.out.println(OutterClass.Inner.d);

        String a = "abc";
        String b = "def";
        String c = "abc" + "def";
        String d = c.intern();

        System.out.println(c == d);

    }

}