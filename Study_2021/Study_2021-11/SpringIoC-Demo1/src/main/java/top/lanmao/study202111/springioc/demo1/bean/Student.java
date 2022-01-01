package top.lanmao.study202111.springioc.demo1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Create Date 2021/11/25 11:21:47 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Student {
    private String stuNum;
    private String stuName;
    private String stuGender;
    private Integer stuAge;
    private Date entranceTime;
    //private List<String> list;
    //private Set<String> set;
    //private Map<String, Object> map;
    //private Properties properties;
}