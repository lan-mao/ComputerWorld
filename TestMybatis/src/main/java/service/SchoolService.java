package service;
/**
 * Create Date 2020/03/04 9:17
 * Created by lan-mao.top
 * TODO 
 *  - 学校信息的服务层
 */
 
public interface SchoolService {
    /**
     * 获取所有的学生信息及对应的班级信息
     */
    void getAllStudentContainClass();
    /**
     * 获取所有的班级包含所有的学生信息
     */
    void getAllClassContainStudent();
}
