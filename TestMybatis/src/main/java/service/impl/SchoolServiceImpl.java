package service.impl;

import mapper.SchoolMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.ClassContainStudent;
import pojo.StudentContainClass;
import service.SchoolService;
import util.MybatisUtil;

import java.io.IOException;
import java.util.List;

/**
 * Create Date 2020/03/05 9:26
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public class SchoolServiceImpl implements SchoolService {
    @Override
    public void getAllStudentContainClass() {
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis.xml"));
            SqlSession session = factory.openSession();
            SchoolMapper mapper = session.getMapper(SchoolMapper.class);
            List<StudentContainClass> studentContainClasses = mapper.listStudentContainClassByAnnotation();
            for (StudentContainClass studentContainClass : studentContainClasses) {
                System.out.println(studentContainClass);
            }
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAllClassContainStudent() {
        SqlSession session = MybatisUtil.getSession();
        SchoolMapper mapper = session.getMapper(SchoolMapper.class);
        List<ClassContainStudent> classContainStudents = mapper.listClassContainStudent();
        for (ClassContainStudent classContainStudent : classContainStudents) {
            System.out.println(classContainStudent);
        }
    }
}
