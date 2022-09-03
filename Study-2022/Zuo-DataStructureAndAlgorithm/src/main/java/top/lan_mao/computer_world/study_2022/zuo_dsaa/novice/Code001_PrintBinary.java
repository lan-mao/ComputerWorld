package top.lan_mao.computer_world.study_2022.zuo_dsaa.novice;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/07/31 10:43 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * 十进制转二进制 <br>
 */
public class Code001_PrintBinary {

    public static String printBinary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            sb.append((num & (1 << i)) == 0 ? 0 : 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(printBinary(Integer.MAX_VALUE));
        //System.out.println(Integer.MIN_VALUE);
        //System.out.println(printBinary(Integer.MIN_VALUE));
        //System.out.println(printBinary(0));
        //System.out.println(printBinary(-0));
        //int a  = Integer.MAX_VALUE | Integer.MIN_VALUE;
        //System.out.println(a);
        //System.out.println(printBinary(a));
        //System.out.println(printBinary(-2));

        //int a = 0;
        //int b = -a;
        //int c = ~a + 1;
        //int d = ~b + 1;
        //int e = ~(a - 1);
        //System.out.println(a);
        //System.out.println(b);
        //System.out.println(c);
        //System.out.println(d);
        //System.out.println(e);
        //
        //int f = Integer.MIN_VALUE;
        //int g = ~f + 1;
        //int h = -f;
        //System.out.println(f);
        //System.out.println(g);
        //System.out.println(h);
        //
        //int i = -2;
        //int j = ~i;
        //System.out.println(printBinary(i));
        //System.out.println(printBinary(j));

        int a = -10;
        int b = a >> 1;
        int c = a >>> 1;

        System.out.println(printBinary(a));
        System.out.println(printBinary(b));
        System.out.println(printBinary(c));

    }
}