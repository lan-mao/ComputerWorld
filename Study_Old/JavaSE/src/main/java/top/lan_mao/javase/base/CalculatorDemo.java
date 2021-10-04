package top.lan_mao.javase.base;

import java.util.Scanner;

/**
 * Create Date 2021/01/10 9:27:22 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 计算器 <br>
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        if (scanner.hasNextInt()) {
            System.out.println(a = scanner.nextInt());
            while (scanner.hasNextLine()) {
                if (scanner.hasNextInt()) {
                    a = scanner.nextInt();
                    System.out.println(a);
                } else {
                    a = calculate(scanner, a);
                }
                //计算完成，结果清零或者得到上一个等式结束，所以结束这次循环。下次循环从0或者上一个结果开始
            }
        }
    }

    public static int calculate(Scanner scanner, int a) {
        int result = a;
        while (scanner.hasNextLine()) {
            String symbol = scanner.nextLine();
            if (symbol.isEmpty()){
                continue;
            }
            switch (symbol) {
                case "+": case "-": case "*": case "/": {
                    System.out.println(a + " " + symbol);
                    if (scanner.hasNextInt()) {
                        int b = scanner.nextInt();
                        switch (symbol) {
                            case "+":
                                result += b;
                                break;
                            case "-":
                                result -= b;
                                break;
                            case "*":
                                result *= b;
                                break;
                            case "/":
                                result /= b;
                                break;
                        }
                        System.out.println(a + " " + symbol + " " + b + " = " + result);
                        a = result;
                    }
                    break;
                }
                case "=":{
                    System.out.println(result);
                    return result;
                }
                default:{
                    System.out.println("输入非法，计算器清零");
                    return 0;
                }
            }
        }
        return 0;
    }

}
