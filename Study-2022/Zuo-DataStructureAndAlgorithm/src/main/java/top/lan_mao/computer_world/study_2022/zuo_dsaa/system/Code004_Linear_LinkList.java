package top.lan_mao.computer_world.study_2022.zuo_dsaa.system;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/08/17 16:17 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * 线性结构相关 <br>
 */
public class Code004_Linear_LinkList {

    public static void main(String[] args) {
        //for (int i = 0; i < 10000; i++) {
        //    LinkList linkList1 = generateLinkList(1000, 100);
        //    String linkListString1 = linkList1.toString();
        //
        //    LinkList linkList2 = reverseLinkList(linkList1);
        //    String linkListString2 = linkList2.toString();
        //
        //    LinkList linkList3 = reverseLinkList(linkList2);
        //    String linkListString3 = linkList3.toString();
        //
        //    if (!linkListString1.equals(linkListString3)) {
        //        System.out.println(i);
        //        System.out.println(linkListString1);
        //        System.out.println(linkListString3);
        //        System.out.println(linkListString2);
        //        return;
        //    }
        //}

        //DoubleLinkList doubleLinkList1 = generateDoubleLinkList(100, 10);
        //System.out.println(doubleLinkList1);
        //System.out.println(doubleLinkList1.toStringByPrevious());
        //DoubleLinkList doubleLinkList2 = reverseDoubleLinkList(doubleLinkList1);
        //System.out.println(doubleLinkList2);
        //System.out.println(doubleLinkList2.toStringByPrevious());
        //DoubleLinkList doubleLinkList3 = reverseDoubleLinkList(doubleLinkList2);
        //System.out.println(doubleLinkList3);
        //System.out.println(doubleLinkList3.toStringByPrevious());

        for (int i = 0; i < 10000; i++) {
            int length = (int)(Math.random() * 10000 +100);
            LinkList a = generateLinkList(length / 10 + 10, length);
            int b = generateRandom(10);
            int num = findNumberOfK(a, b);
            boolean flag = false;
            if (a.data == b) {
                System.out.println(a);
                flag = true;
            }
            LinkList c = deleteNodeByNumber(a, b);
            int num2 = findNumberOfK(c, b);
            int length2 = c.length();
            if (num2 != 0 || length2 != length - num) {
                System.out.println("失败");
                System.out.println(c);
                System.out.println(b);
                return;
            }
            if (flag) {
                System.out.println(c);
                System.out.println();
            }
        }
    }


    public static LinkList generateLinkList(int range, int length) {
        LinkList head = new LinkList(generateRandom(range), null);
        LinkList temp = head;
        for (int i = 0; i < length - 1; i++) {
            temp.next = new LinkList(generateRandom(range), null);
            temp = temp.next;
        }
        return head;
    }
    public static DoubleLinkList generateDoubleLinkList(int range, int length) {
        DoubleLinkList head = new DoubleLinkList(generateRandom(range), null, null);
        DoubleLinkList temp = head;
        for (int i = 0; i < length - 1; i++) {
            temp.next = new DoubleLinkList(generateRandom(range), temp, null);
            temp = temp.next;
        }
        return head;
    }

    public static int generateRandom(int range) {
        return (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
    }

    static class LinkList {
        public int data;
        public LinkList next;

        public LinkList(int data, LinkList next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            LinkList temp = this;
            while (temp != null) {
                sb.append(temp.data).append(", ");
                temp = temp.next;
            }
            sb.deleteCharAt(sb.lastIndexOf(", "));
            sb.append("]");
            return sb.toString();
        }

        public int length() {
            int n = 1;
            LinkList temp = next;
            while (temp != null) {
                n++;
                temp = temp.next;
            }
            return n;
        }

    }

    static class DoubleLinkList {
        public int data;
        public DoubleLinkList previous;
        public DoubleLinkList next;

        public DoubleLinkList(int data, DoubleLinkList previous, DoubleLinkList next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            DoubleLinkList temp = this;
            sb.append("[");
            while (temp != null) {
                sb.append(temp.data).append(", ");
                temp = temp.next;
            }
            sb.deleteCharAt(sb.lastIndexOf(", "));
            sb.append("]");
            return sb.toString();
        }

        public String toStringByPrevious() {
            DoubleLinkList point = this;
            while (point.next != null) {
                point = point.next;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (point != null) {
                sb.append(point.data).append(", ");
                point = point.previous;
            }
            sb.deleteCharAt(sb.lastIndexOf(", "));
            sb.append("]");
            return sb.toString();
        }

    }

    public static LinkList reverseLinkList(LinkList list) {
        // × 出错1：开头的last 没有设null，导致输出时死循环
        LinkList last = list;
        LinkList next = list.next;
        last.next = null;
        while (next != null) {
            LinkList temp = next.next;
            next.next = last;
            last = next;
            next = temp;
        }
        return last;
    }

    public static DoubleLinkList reverseDoubleLinkList(DoubleLinkList list) {
        DoubleLinkList last = list;
        DoubleLinkList next = list.next;
        last.next = null;
        while (next != null) {
            DoubleLinkList temp = next.next;
            next.previous = next.next;
            next.next = last;
            last.previous = next;
            last = next;
            next = temp;
        }
        return  last;
    }

    public static LinkList deleteNodeByNumber(LinkList list, int number) {
        if (list == null) {
            return null;
        }
        LinkList temp = list;
        if (temp.data == number) {
            while (temp != null && temp.data == number) {
                temp = temp.next;
            }
        }
        if (temp == null) {
            return null;
        }
        LinkList head = temp;
        while (temp.next != null) {
            if (temp.next.data == number) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static int findNumberOfK(LinkList list, int number) {
        int num = 0;
        while (list != null) {
            if (list.data == number) {
                num ++;
            }
            list = list.next;
        }
        return num;
    }


}