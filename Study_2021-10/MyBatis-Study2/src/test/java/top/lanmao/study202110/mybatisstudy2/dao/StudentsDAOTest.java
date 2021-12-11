package top.lanmao.study202110.mybatisstudy2.dao;

import org.junit.jupiter.api.Test;
import top.lanmao.study202110.mybatisstudy2.pojo.Students;
import top.lanmao.study202110.mybatisstudy2.util.MyBatisUtils;

class StudentsDAOTest {

    @Test
    void getStudentsByCid() {
        StudentsDAO studentsDAO = MyBatisUtils.getMapper(StudentsDAO.class);
        Students students = studentsDAO.getStudentsById("2104");
        System.out.println(students);
    }
}