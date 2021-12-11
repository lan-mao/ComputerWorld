package top.lanmao.study202110.mybatisstudy2.dao;

import top.lanmao.study202110.mybatisstudy2.pojo.Classes;

/**
 * Create Date 2021/11/05 11:24:13 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public interface ClassesDAO {
    Classes getClassesById(Long id);
}