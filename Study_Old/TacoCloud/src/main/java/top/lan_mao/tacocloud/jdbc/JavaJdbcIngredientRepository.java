package top.lan_mao.tacocloud.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import top.lan_mao.tacocloud.data.Ingredient;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Create Date 2021/04/20 18:12:16 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 使用Java的jdbc代码 <br>
 */
@Repository
@RequiredArgsConstructor
public class JavaJdbcIngredientRepository implements IngredientRepository {

    private static String driver = "com.h2.Driver";
    private static String url = "jdbc:ht:tcp://localhost:8082/taco_cloud";

    private final DataSource dataSource;

    @Override
    public Iterable<Ingredient> findAll() {
        List<Ingredient> ingredientList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(
                    "select id, name, type from ingredient"
            );
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        Ingredient.Type.valueOf(resultSet.getString("type")));
                ingredientList.add(ingredient);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ingredientList;
    }

    @Override
    public Ingredient findOne(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url);
            statement = connection.prepareStatement(
                    "select id, name, type from ingredient where id = ?"
            );
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            Ingredient ingredient = null;
            if (resultSet.next()) {
                ingredient = new Ingredient(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        Ingredient.Type.valueOf(resultSet.getString("type")));
            }
            return ingredient;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int saveOne(Ingredient ingredient) {
        return 0;
    }
}