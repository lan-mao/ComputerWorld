package top.lanmao.study202110.mybatisstudy2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Create Date 2021/11/05 16:46:40 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Course {
    private Long courseId;
    private String courseName;

    private List<Students> studentsList;
}