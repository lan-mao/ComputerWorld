package top.lanmao.study202110.mybatisstudy2.dao;

import top.lanmao.study202110.mybatisstudy2.pojo.Course;

/**
 * Create Date 2021/11/05 16:48:28 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public interface CourseDAO {
    Course getCourseByCourseId(Long id);
}