package top.lanmao.study202110.mybatisstudy.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import top.lanmao.study202110.mybatisstudy.pojo.StudentDO;
import top.lanmao.study202110.mybatisstudy.pojo.StudentQuery;
import top.lanmao.study202110.mybatisstudy.util.MyBatisUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDAOTest {

    static StudentDAO studentDAO;

    static SqlSession sqlSession;

    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        sqlSession = MyBatisUtils.getSqlSessionNotAutoCommit();
        studentDAO = sqlSession.getMapper(StudentDAO.class);
    }

    @Test
    void insertStudent() {
        StudentDO student01 = new StudentDO();
        student01.setStuName("李华");
        student01.setStuAge(100);
        student01.setStuNum("10070");
        student01.setStuGender("1");
        student01.setCreateTime(new Timestamp(System.currentTimeMillis()));
        student01.setUpdateTime(student01.getCreateTime());
        int i = studentDAO.insertStudent(student01);
        System.out.println(student01);
    }

    @Test
    void deleteStudentByNum() {
        System.out.println(studentDAO.deleteStudentByNum("12345"));
    }

    @Test
    void deleteStudentById() {
        System.out.println(studentDAO.deleteStudentById(14L));
    }


    @Test
    void testUpdateStudentById() {
        StudentDO student = new StudentDO(17L,
                "12311",
                "test",
                "7",
                16,
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()));
        int result = studentDAO.updateStudentById(student);
        assertEquals(0, result);
    }

    @Test
    void testSelectAll() {
        StudentQuery studentQuery = new StudentQuery();
        List<StudentDO> studentDOList = studentDAO.listStudentByParameter(studentQuery);
        System.out.println(studentDOList);
    }
    @Test
    void testSelectByParameter() {
        StudentQuery studentQuery = new StudentQuery().setStuNum("10000");
        List<StudentDO> studentDOList = studentDAO.listStudentByParameter(studentQuery);
        System.out.println(studentDOList);
    }

    @Test
    void testListAllStudentReturnSet() {
        Set<StudentDO> studentDOList = studentDAO.listAllStudent();
        System.out.println(studentDOList);
    }

    @Test
    void testListStudentByPage() {
        StudentQuery studentQuery = new StudentQuery().setStart(1).setPageSize(2);
        List<StudentDO> studentDOList1 = studentDAO.listStudentByPage(0, 2);
        List<StudentDO> studentDOList2 = studentDAO.listStudentByParameter(studentQuery);
        System.out.println(studentDOList1);
        System.out.println(studentDOList2);
    }

    @Test
    void testCountStudent() {
        int count = studentDAO.countStudent();
        assertEquals(count, 3);
    }

    @Test
    void testListStudentByParameter() {
        PageHelper.startPage(2, 2);
        List<StudentDO> studentList = studentDAO.listStudentByParameter(new StudentQuery());
        PageInfo<StudentDO> studentDOPageInfo = new PageInfo<>(studentList);
        System.out.println(studentDOPageInfo);
    }

    @AfterAll
    static void afterAll() {
        sqlSession.commit();
        sqlSession.close();
    }
}