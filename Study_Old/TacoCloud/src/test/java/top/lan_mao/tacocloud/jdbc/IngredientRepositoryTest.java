package top.lan_mao.tacocloud.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@JdbcTest()
class IngredientRepositoryTest {

    @Autowired
    DataSource source;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private JdbcTemplateIngredientRepository jdbcTemplateIngredientRepository;
    //@Autowired
    //private JavaJdbcIngredientRepository javaJdbcIngredientRepository;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        //jdbcTemplateIngredientRepository.findAll().forEach(Ingredient::toString);
        System.out.println((Integer)jdbcTemplate.queryForObject("select count(*) from ingredient",
                (rs, num) -> rs.getInt(1)));
    }

    @Test
    void findOne() {
    }

    @Test
    void saveOne() {

    }
}