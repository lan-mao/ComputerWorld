package top.lan_mao.list;

/**
 * Create Date 2020/03/09 11:19
 * Created by lan-mao.top
 *  - 使用循环链表解决约瑟夫环
 * @
 */

public class YosefCycleLinkList {
    /**
     *
     * @param n n个人
     * @param m 第m个人杀掉
     */
    public static void yosef(int n,int m) {
        YosefNode firstNode = new YosefNode();
        YosefNode pointerNode = firstNode;
        int num = 0;
        for (int i = 0;i<n;i++){
            pointerNode.nextNode = new YosefNode();
            pointerNode.num = i+1;
            pointerNode = pointerNode.nextNode;
            num++;
        }
        pointerNode.nextNode = firstNode;
        int count = 0;
        while (num > 1) {
            count ++;
            if (count == m) {
                while (pointerNode.isDie) {
                    pointerNode = pointerNode.nextNode;
                }
                num--;
                count = 0;
            } else {
                while (pointerNode.isDie) {
                    pointerNode = pointerNode.nextNode;
                }
            }
        }
        System.out.println(pointerNode);
    }

    public static void main(String[] args) {
        yosef(6, 5);
    }
}

class YosefNode{
    boolean isDie = false;
    YosefNode nextNode;
    int num ;

    @Override
    public String toString() {
        return "YosefNode{" + "isDie=" + isDie +
                ", num=" + num +
                '}';
    }

}