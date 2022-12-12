package cl.example.demoBCI.controller

import org.spockframework.spring.SpringBean;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification
import spock.lang.Title;


@Title("Esta especificación prueba el Hello World")
@AutoConfigureMockMvc
@WebMvcTest
public class HelloWorldControllerSpec extends Specification {

    @Autowired
    private MockMvc mvc

    def setup() {
        //
    }

    def "helloWorld devuelve el string Hello World es un estatus 200"(){
        when: "controller recibe llamado"
        def resultado = mvc.perform(MockMvcRequestBuilders.get("/test/hello"))

        then: "controller responde con estatus 200"
        resultado.andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .response
                .contentAsString == "Hello World"
    }

}
