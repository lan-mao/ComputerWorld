package top.lan_mao.tacocloud.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

/**
 * Create Date 2021/04/04 17:11:54 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taco {
    private Long id;
    private Date created;
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    public String name;
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<String> ingredients;
}