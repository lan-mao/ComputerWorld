package top.lan_mao.computer_world.study_2022.ssm_demo01.service;

import org.springframework.stereotype.Service;
import top.lan_mao.computer_world.study_2022.ssm_demo01.dao.BookDao;
import top.lan_mao.computer_world.study_2022.ssm_demo01.pojo.Books;

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
 * Create Date 2022/01/22 22:18:24 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * <br>
 */

@Service
public class BookServiceImpl implements BookService{

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public int insertBook(Books book) {
        return bookDao.insertBook(book);
    }

    @Override
    public int deleteBookById(Long id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Books book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Books getBookById(Long id) {
        return bookDao.getBookById(id);
    }

    @Override
    public List<Books> listAllBooks() {
        return bookDao.listAllBooks();
    }
}