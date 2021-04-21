package top.lan_mao.tacocloud.data;

import lombok.Data;

/**
 * Create Date 2021/04/04 15:34:54 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * taco的配料 <br>
 */
@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;
    public enum Type{
        //包，蛋白质，蔬菜，起司，酱
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}