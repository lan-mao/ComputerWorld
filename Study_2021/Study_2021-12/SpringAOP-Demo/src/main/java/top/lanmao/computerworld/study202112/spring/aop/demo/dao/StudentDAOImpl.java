package top.lanmao.computerworld.study202112.spring.aop.demo.dao;

/**
 * Create Date 2021/12/08 17:48:13 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class StudentDAOImpl implements GeneralDAO {
    @Override
    public void delete() {
        System.out.println("删除student");
    }

    @Override
    public void insert() {
        System.out.println("插入student");
    }

    @Override
    public void update() {
        System.out.println("更新student");
    }
}