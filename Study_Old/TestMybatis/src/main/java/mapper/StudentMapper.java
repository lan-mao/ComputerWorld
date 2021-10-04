package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Student;

import java.util.List;

/**
 * Create Date 2020/03/05 9:21
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public interface StudentMapper {
    /**
     * 获取所有的学生表记录
     * @return list集合
     */
    List<Student> listAll();

    /**
     * 通过id获取对应的学生记录
     * @param id 对应的id
     * @return
     */
    Student getById (@Param("id") Integer id);

    /**
     * 通过班级id查找对应的班级的学生列表
     * @param cid 班级id
     * @return
     */
    List<Student> listByCid (@Param("cid")Integer cid);
}
