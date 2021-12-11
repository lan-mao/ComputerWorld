package top.lanmao.scriptplatform.suwayun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create Date 2021/10/05 9:37:12 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * json解析的数据实体类 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageBO {
    private Integer code;
    private String message;
    private MessageData data;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class MessageData {
    private String message;
}