package top.lanmao.study202110.mybatisstudy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import top.lanmao.study202110.mybatisstudy.pojo.StudentDO;
import top.lanmao.study202110.mybatisstudy.pojo.StudentQuery;

import java.util.List;
import java.util.Set;

/**
 * Create Date 2021/10/03 9:49:51 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public interface StudentDAO {
    /**
     * 存储学生信息
     * @param student 传入student信息
     * @return 成功返回1
     */
    int insertStudent(StudentDO student);

    /**
     * 通过学号num删除学生信息
     * @param stuNum 传入学生学号
     * @return 成功返回1
     */
    int deleteStudentByNum(String stuNum);

    /**
     * 通过id删除学生信息
     * @param sid 学生信息的id
     * @return 成功返回1
     */
    @Delete("delete from student where sid = #{sid}")
    int deleteStudentById(Long sid);

    /**
     * 通过id修改信息
     * @param student 学生信息
     * @return 成功返回1
     */
    int updateStudentById(StudentDO student);

    /**
     * 通过传入的参数查询符合条件的学生信息，可以进行精确查询
     * @param studentQuery 传入的学生表查询条件
     * @return 所有符合条件的学生信息
     */
    List<StudentDO> listStudentByParameter(StudentQuery studentQuery);

    /**
     * 获取所有的学生对象
     * @return 返回set类型的学生信息
     */
    Set<StudentDO> listAllStudent();

    /**
     * 分页查询所有的列表数据
     * @param start 开始位置
     * @param pageSize 分页大小
     * @return 返回列表
     */
    List<StudentDO> listStudentByPage(@Param("start")int start, @Param("pageSize")int pageSize);

    /**
     * 获取学生数量
     * @return 学生表中的数量
     */
    int countStudent();
}