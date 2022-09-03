package top.lan_mao.computer_world.study_2022.zuo_dsaa.system;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/08/29 16:56 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * 栈与队列之间的转换 <br>
 */
public class Code004_Linear_QueueAndStack {

    static class QueueByStack<E> {
        private Stack<E> push;
        private Stack<E> pop;

        public QueueByStack() {
            push = new Stack<>();
            pop = new Stack<>();
        }

        public void add(E e) {
            push.push(e);
        }

        public E poll() {
            if (pop.isEmpty() && push.isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            pushToPop();
            return pop.pop();
        }

        private void pushToPop() {
            if (pop.isEmpty()) {
                while (!push.isEmpty()) {
                    pop.push(push.pop());
                }
            }
        }

        public E peek() {
            if (pop.isEmpty() && push.isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            pushToPop();
            return pop.peek();
        }
    }

    static class StackByQueue<E> {
        private Queue<E> aQueue;
        private Queue<E> bQueue;

        public StackByQueue() {
            aQueue = new ArrayDeque<>();
            bQueue = new ArrayDeque<>();
        }

        public void aExB() {
            while (aQueue.size() > 1) {
                bQueue.add(aQueue.poll());
            }
        }

        public void push(E value) {
            aQueue.add(value);
        }

        public E pop() {
            if (aQueue.isEmpty() && bQueue.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            aExB();
            Queue<E> temp = aQueue;
            aQueue = bQueue;
            bQueue = temp;
            return bQueue.poll();
        }

        public E peek() {
            if (aQueue.isEmpty() && bQueue.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            aExB();
            E result  = aQueue.poll();
            bQueue.add(result);
            Queue<E> temp = aQueue;
            aQueue = bQueue;
            bQueue = temp;
            return result;
        }
    }

    static class StackBySingleQueue<E> {
        private Queue<E> queue;

        public StackBySingleQueue() {
            queue = new ArrayDeque<>();
        }

        public void pull(E x) {
            int size = queue.size();
            queue.add(x);
            for (int i = 0; i < size; i++) {
                queue.add(queue.poll());
            }
        }

        public E pop() {
            return queue.poll();
        }

        public E top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}