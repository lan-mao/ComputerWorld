package service.impl;

import org.junit.jupiter.api.Test;
import service.SchoolService;

import static org.junit.jupiter.api.Assertions.*;

class SchoolServiceImplTest {

    @Test
    void getAllStudentAndClass() {
        SchoolService schoolService = new SchoolServiceImpl();
        schoolService.getAllStudentContainClass();
    }
}