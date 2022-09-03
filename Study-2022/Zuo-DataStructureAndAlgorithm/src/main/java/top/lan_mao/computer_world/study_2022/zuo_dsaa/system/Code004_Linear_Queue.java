package top.lan_mao.computer_world.study_2022.zuo_dsaa.system;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/08/23 17:25 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * 队列 <br>
 */
public class Code004_Linear_Queue {
    static class QueueByArray {
        public int[] data;
        public int prePoint;
        public int lastPoint;
        public int length;
        public int size;

        public QueueByArray(int size) {
            this.size = size;
            data = new int[size];
            prePoint = 0;
            lastPoint = 0;
            length = 0;
        }

        public boolean offer(int value) {
            if (length == size) {
                return false;
            }
            data[lastPoint] = value;
            lastPoint = (lastPoint + 1) % size;
            length ++;
            return true;
        }

        public int poll() {
            if (length == 0) {
                throw new RuntimeException("栈为空");
            }
            length--;
            int result = data[prePoint];
            prePoint = (prePoint + 1) % size;
            return result;
        }

        public boolean isEmpty() {
            return length == 0;
        }
    }

    public static void main(String[] args) {
        QueueByArray a = new QueueByArray(10);
        for (int i = 0; i < 10; i++) {
            int temp = (int)(Math.random() * 100);
            a.offer(temp);
            System.out.print(temp);
        }
        System.out.println();
        while (!a.isEmpty()) {
            System.out.print(a.poll());
        }
        System.out.println();
    }
}