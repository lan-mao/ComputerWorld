package top.lan_mao.tacocloud.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.lan_mao.tacocloud.data.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create Date 2021/04/21 8:45:38 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 使用Spring的JDBCTemplate类 <br>
 */
@Repository
@RequiredArgsConstructor
public class JdbcTemplateIngredientRepository implements IngredintRepository{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from ingredient", this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbcTemplate.queryForObject("select id, name, type from ingredient where id = ?",
                this::mapRowToIngredient, id);
    }

    @Override
    public int saveOne(Ingredient ingredient) {
        return jdbcTemplate.update("insert into ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }
}