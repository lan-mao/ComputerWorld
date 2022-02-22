package top.lan_mao.computer_world.study_2022.springmvc_demo04_json.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Create Date 2022/01/09 18:35:36 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
    private String name;
    private Integer age;
    private String sex;
}