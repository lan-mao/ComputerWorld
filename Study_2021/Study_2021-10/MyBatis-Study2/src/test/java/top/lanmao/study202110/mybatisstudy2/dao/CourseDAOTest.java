package top.lanmao.study202110.mybatisstudy2.dao;

import org.junit.jupiter.api.Test;
import top.lanmao.study202110.mybatisstudy2.util.MyBatisUtils;

import static org.junit.jupiter.api.Assertions.*;

class CourseDAOTest {

    @Test
    void testGetCourseByCourseId() {
        CourseDAO courseDAO = MyBatisUtils.getMapper(CourseDAO.class);
        System.out.println(courseDAO.getCourseByCourseId(111L));
    }
}