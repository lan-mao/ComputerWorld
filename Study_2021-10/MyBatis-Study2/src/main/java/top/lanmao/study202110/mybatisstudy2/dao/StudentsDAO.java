package top.lanmao.study202110.mybatisstudy2.dao;

import top.lanmao.study202110.mybatisstudy2.pojo.Students;

import java.util.List;

/**
 * Create Date 2021/11/05 12:12:3 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public interface StudentsDAO {
    Students getStudentsById(String id);
    List<Students> listStudentsByCourseId(Long id);
}