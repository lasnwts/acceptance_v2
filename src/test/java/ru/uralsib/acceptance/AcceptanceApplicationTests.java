package ru.uralsib.acceptance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.uralsib.acceptance.rescontroller.ResControllerMF;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AcceptanceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ResControllerMF resControllerMF;

    @Test
    public void contextLoads() {
        assertThat(resControllerMF).isNotNull();
    }

    @Test
    public void conetstLoadHtml() throws Exception {
        this.mockMvc.perform(get("/api/v1/id/100001"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("5888068")));
    }

}
