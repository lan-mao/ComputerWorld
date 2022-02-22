package top.lan_mao.computer_world.study_2022.ssm_demo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.lan_mao.computer_world.study_2022.ssm_demo01.pojo.Books;
import top.lan_mao.computer_world.study_2022.ssm_demo01.service.BookService;

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
 * Create Date 2022/01/24 21:49:5 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * <br>
 */

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/all")
    public String listBook(Model model) {
        List<Books> books = bookService.listAllBooks();
        model.addAttribute("books", books);
        return "allBook";
    }

    @RequestMapping("/input")
    public String inputBook(Books book,Model model) {
        int i = bookService.insertBook(book);
        if (i == 0) {
            model.addAttribute("msg", book.getBookDetail());
        } else{
            model.addAttribute("msg", "失败");
        }
        return "result";
    }
}