package top.lan_mao.Study_2021_10.MyBatis_Study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create Date 2021/10/03 9:36:34 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int sid;
    private String stuNum;
    private String stuName;
    private String stuGender;
    private String stuAge;
}