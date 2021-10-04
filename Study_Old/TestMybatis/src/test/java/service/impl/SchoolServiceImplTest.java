package service.impl;

import org.junit.jupiter.api.Test;
import service.SchoolService;

class SchoolServiceImplTest {

    @Test
    void getAllStudentAndClass() {
        SchoolService schoolService = new SchoolServiceImpl();
        schoolService.getAllStudentContainClass();
    }
}