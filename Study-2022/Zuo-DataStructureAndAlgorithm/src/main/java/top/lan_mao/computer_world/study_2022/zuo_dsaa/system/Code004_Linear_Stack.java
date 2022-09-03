package top.lan_mao.computer_world.study_2022.zuo_dsaa.system;

import java.util.EmptyStackException;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/08/23 17:01 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * 栈 <br>
 */
public class Code004_Linear_Stack {
    class StackByArray{
        public int[] data;
        public int point;
        public StackByArray(int length) {
            data = new int[length];
            point = 0;
        }

        public boolean push(int value) {
            if (point == data.length) {
                return false;
            }
            data[point++] = value;
            return true;
        }

        public int pop() {
            if (point == 0) {
                throw new EmptyStackException();
            }
            return data[--point];
        }

        public int peek() {
            if (point == 0) {
                throw new EmptyStackException();
            }
            return data[point - 1];
        }
    }

    static class StackByArrayGetMinMax{
        public int[] data;
        public int[] minData;
        public int[] maxData;
        public int valueLength;
        public int size;

        public StackByArrayGetMinMax() {
            size = 10;
            data = new int[size];
            minData = new int[size];
            maxData = new int[size];
            valueLength = 0;
        }

        public int pop() {
            if (valueLength <= 0) {
                throw new RuntimeException("栈为空");
            }
            return data[--valueLength];
        }

        public void push(int value) {
            if (valueLength == size) {
                size = size + (size / 2);
                int[] a = new int[size];
                int[] b = new int[size];
                int[] c = new int[size];
                System.arraycopy(data, 0, a, 0, valueLength);
                System.arraycopy(minData, 0, b, 0, valueLength);
                System.arraycopy(maxData, 0, c, 0, valueLength);
                data = a;
                minData = b;
                maxData = c;
            }

            data[valueLength] = value;
            if (valueLength != 0) {
                minData[valueLength] = Math.min(minData[valueLength - 1], value);
                maxData[valueLength] = Math.max(maxData[valueLength - 1], value);
            } else {
                minData[valueLength] = value;
                maxData[valueLength] = value;
            }
            valueLength++;
        }

        public int getMaxValue() {
            return maxData[valueLength - 1];
        }

        public int getMinValue() {
            return minData[valueLength - 1];
        }

    }

    public static void main(String[] args) {
        StackByArrayGetMinMax minStack = new StackByArrayGetMinMax();
        for (int i = 1; i < 1000; i++) {
            int temp = (int) (Math.random() * 100000);
            System.out.println(temp);
            minStack.push(temp);
            if (i % 10 == 0) {
                System.out.println(minStack.pop());
            }
            if (i % 3 == 0) {
                System.out.println(minStack.getMinValue());
            }
            if (i % 7 == 0) {
                System.out.println(minStack.getMaxValue());
            }
        }
    }
}