package top.lanmao.computerworld.study202112.spring.aop.demo2.dao;

import org.springframework.stereotype.Repository;

/**
 * Create Date 2021/12/12 18:36:24 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Repository
public class BookDAO {
    public void delete() {
        System.out.println("删除");
    }

    public void update() {
        System.out.println("更新");
    }

    public void insert() {
        System.out.println("插入");
    }
}