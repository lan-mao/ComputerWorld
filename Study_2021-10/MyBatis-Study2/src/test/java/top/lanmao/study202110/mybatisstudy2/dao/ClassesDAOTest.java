package top.lanmao.study202110.mybatisstudy2.dao;

import org.junit.jupiter.api.Test;
import top.lanmao.study202110.mybatisstudy2.pojo.Classes;
import top.lanmao.study202110.mybatisstudy2.util.MyBatisUtils;

class ClassesDAOTest {

    @Test
    void testGetClassesById() {
        ClassesDAO classesDAO = MyBatisUtils.getMapper(ClassesDAO.class);
        Classes classes = classesDAO.getClassesById(1L);
        System.out.println(classes);
    }

}