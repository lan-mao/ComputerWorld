package top.lanmao.computerworld.study202112.spring.aop.demo.dao;

/**
 * Create Date 2021/12/08 17:50:1 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class BookDAOImpl {
    public void delete() {
        System.out.println("删除book");
    }

    public void insert() {
        System.out.println("插入book");
    }

    public void update() {
        System.out.println("更新book");
    }

    public void delete(String id) {
        System.out.println("执行删除：" + id);
        throw new NullPointerException();
    }
}