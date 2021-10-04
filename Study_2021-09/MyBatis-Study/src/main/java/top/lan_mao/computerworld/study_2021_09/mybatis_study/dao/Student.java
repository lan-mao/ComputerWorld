package top.lan_mao.computerworld.study_2021_09.mybatis_study.dao;

import lombok.*;

/**
 * Create Date 2021/09/23 16:15:36 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Data
@NoArgsConstructor
public class Student {
    private Integer sid;
    private String stuNum;
    private String stuName;
    private String stuGender;
    private Integer stuAge;
}