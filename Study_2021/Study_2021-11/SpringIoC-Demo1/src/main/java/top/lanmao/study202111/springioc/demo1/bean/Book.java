package top.lanmao.study202111.springioc.demo1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Create Date 2021/11/29 17:21:21 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Book {
    private String name;
    private String author;

    public void init(){
        System.out.println("初始化对象");
    }
    public void destroy(){
        System.out.println("销毁对象");
    }
}