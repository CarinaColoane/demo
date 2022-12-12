package cl.example.demoBCI.controller

import cl.example.demoBCI.dto.UserResponseTO
import cl.example.demoBCI.service.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.http.MediaType
import spock.lang.Specification
import spock.lang.Title

@Title("Esta especificación prueba ...")
@AutoConfigureMockMvc
@WebMvcTest
public class UserControllerSpec extends Specification {

    @Autowired
    private MockMvc mvc

    private UserServiceImpl userService;

    String USER_REQUEST_BODY = """
        {
            "name": "%s",
            "email": "%s",
            "password": "%s",
            "phones": [{"number": "%s", "citycode": "%s", "countrycode": "%s"}]
        }
    """
    String name = "Juan Rodriguez"
    String email = "juan@rodriguez.org"
    String password =  "hunter2"
    String number = "1234567"
    String citycode = "1"
    String countrycode = "57"

    String USER_RESPONSE_BODY = """
        {
            "id": "%s",
            "created": "%s",
            "modified": "%s",
            "last_login": "%s",
            "token": "%s",
            "isactive": "%s"
        }
    """
    UUID id = UUID.randomUUID()
    String created = 1
    String modified = 1
    String last_login = 1
    UUID token = id
    String isactive = 1
    UserResponseTO responseCreateUser = new UserResponseTO(id, created, modified, last_login, token, isactive)

    def setup() {
        def userService = Mock(UserServiceImpl.class)
    }

    def "UserController crea usuario"(){
        given: "dada la estructura del json"
        def createUserRequestJson = String.format(USER_REQUEST_BODY, name, email, password, number, citycode, countrycode)
        def createUserResponseJson = String.format(USER_RESPONSE_BODY, id, created, modified, last_login, token, isactive)

        when: "controller recibe json"
        userService.createUser(createUserRequestJson) >> responseCreateUser
        def response = mvc.perform(MockMvcRequestBuilders.post("/usuario/crear")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(createUserRequestJson))
                                    .andReturn().response

        then: "retorna un json y estatus 200"
        response.status == HttpStatus.OK.value()
        //response.contentAsString == createUserResponseJson

    }

}
