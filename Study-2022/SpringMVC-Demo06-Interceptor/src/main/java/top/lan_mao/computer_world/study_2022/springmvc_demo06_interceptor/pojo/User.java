package top.lan_mao.computer_world.study_2022.springmvc_demo06_interceptor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Create Date 2022/01/13 12:5:20 <br>
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
}