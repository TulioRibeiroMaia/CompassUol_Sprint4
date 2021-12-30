package Avaliacao.Sprint4.PartidosPoliticos.Controller;

import Avaliacao.Sprint4.PartidosPoliticos.Entity.Associates;
import Avaliacao.Sprint4.PartidosPoliticos.config.Handler.ObjectMapperConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AssociatesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    //Deve retornar um 400 se o gênero for diferente de Masculino e Feminino
    @Test
    public void associatesTestRegister() throws Exception {

        URI uri = new URI("/associados");
        String json = "{\"name\": \"Joana\", \"birthDate\": \"2000-01-05\",\"gender\": \"OTHER\", \"politicalParties\": \"VEREADOR}\"";

        mockMvc.perform(post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    public void listByFilterGetAll() throws Exception {
        mockMvc.perform(get("/associados"))
                .andExpect(status().isOk());
    }

}