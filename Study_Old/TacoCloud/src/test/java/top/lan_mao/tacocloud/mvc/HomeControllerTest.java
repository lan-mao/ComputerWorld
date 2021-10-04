package top.lan_mao.tacocloud.mvc;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Create Date 2021/04/04 10:25:06 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */


@WebMvcTest()
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.containsString("Welcome to ...")
                ));
    }
}