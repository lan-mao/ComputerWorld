package top.lan_mao.computer_world.study_2022.ssm_demo01.dao;

import org.apache.ibatis.annotations.Param;
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
 * Create Date 2022/01/22 21:43:19 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * <br>
 */
public interface BookDao {
    int insertBook(Books book);
    int deleteBookById(@Param("bookId") Long id);
    int updateBook(Books book);
    Books getBookById(@Param("bookId") Long id);
    List<Books> listAllBooks();
}