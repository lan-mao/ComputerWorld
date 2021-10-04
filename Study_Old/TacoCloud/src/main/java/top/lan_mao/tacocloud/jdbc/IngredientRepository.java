package top.lan_mao.tacocloud.jdbc;

import top.lan_mao.tacocloud.data.Ingredient;

/**
 * Create Date 2021/04/20 18:33:04 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    int saveOne(Ingredient ingredient);
}