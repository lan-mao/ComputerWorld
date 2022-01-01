package mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pojo.ClassContainStudent;
import pojo.StudentContainClass;

import java.util.List;

/**
 * Create Date 2020/03/03 21:09
 * Created by lan-mao.top
 *  - class,teacher,student的mapper映射文件
 */

public interface SchoolMapper {
    List<StudentContainClass> listStudentContainClass();
    List<ClassContainStudent> listClassContainStudent();

    @Select("select * from student")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(column = "age",property = "age"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "cid",property = "cid"),
            @Result(property = "clazz",one = @One(select = "mapper.ClassMapper.getById"),column = "cid")
    })
    List<StudentContainClass> listStudentContainClassByAnnotation();
}