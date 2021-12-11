package top.lanmao.study202110.mybatisstudy2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * Create Date 2021/11/05 8:46:24 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Classes {
    private Long cId;
    private String cName;
    private String cDesc;
    private Timestamp createTime;
    private Timestamp updateTime;

    //private List<Students> students;
}