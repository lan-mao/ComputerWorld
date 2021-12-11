package top.lanmao.tacocloud.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create Date 2021/04/04 15:34:54 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * taco的配料 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    private String id;
    private String name;
    private Type type;
    public enum Type{
        //包，蛋白质，蔬菜，起司，酱
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}