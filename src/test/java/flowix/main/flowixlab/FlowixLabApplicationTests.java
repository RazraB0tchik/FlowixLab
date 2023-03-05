package flowix.main.flowixlab;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jdi.ObjectReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class FlowixLabApplicationTests {

    private MockMvc mockMvc;

//    @Autowired
//    ObjectMapper objectMapper;

    @Test
    public void testLogin() throws Exception {
        this.mockMvc.perform(post("/login")
                .contentType("application/json")
//                .param("telegramId", "1451501509")
                .content("{\"telegramId\", \"1451501509\"}"))
                .andExpect(status().isOk());
    }

}
