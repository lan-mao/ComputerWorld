import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.lan_mao.computer_world.study_2022.ssm_demo01.dao.BookDao;
import top.lan_mao.computer_world.study_2022.ssm_demo01.pojo.Books;

import java.io.IOException;
import java.util.List;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/01/24 22:9:11 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * <br>
 */
public class MyTest {

    @Test
    public void getBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bean = context.getBean(BookDao.class);
        List<Books> books = bean.listAllBooks();
        for (Books book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testMybatis() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        BookDao bookDao = build.openSession().getMapper(BookDao.class);
        System.out.println(bookDao.listAllBooks());
        List<Books> books = bookDao.listAllBooks();
        for (Books book : books) {
            System.out.println(book.getBookId());
        }
    }
}