package top.lan_mao.computer_world.study_2022.springmvc_demo05_ajax.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Create Date 2022/01/12 17:25:20 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private String name;
    private Integer age;
    private String sex;
}