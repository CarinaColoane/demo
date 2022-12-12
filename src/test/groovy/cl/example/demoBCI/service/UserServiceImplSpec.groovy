package cl.example.demoBCI.service

import cl.example.demoBCI.dto.PhoneTO
import cl.example.demoBCI.dto.UserRequestTO
import cl.example.demoBCI.dto.UserResponseTO
import spock.lang.Specification
import spock.lang.Title

@Title("Esta especificación prueba ...")
class UserServiceImplSpec extends Specification {
    private UserServiceImpl userService;

    def setup() {
        def userService = Mock(UserServiceImpl.class)
    }

    def "UserService crea usuario"(){
        given: "dado una request y response"
        UUID randomUUID = UUID.randomUUID()
        PhoneTO phone = new PhoneTO()
        phone.setNumber("123")
        phone.setCitycode("123")
        phone.setCountrycode("123")

        UserRequestTO userRequest =
                UserRequestTO.builder()
                        .name("asdf")
                        .email("asdf")
                        .password("asdf")
                        .phones([phone])
                        .build()
        UserResponseTO userResponse =
                UserResponseTO.builder()
                        .id(randomUUID)
                        .created("now")
                        .modified("now")
                        .last_login("now")
                        .token(randomUUID)
                        .isactive("yes")
                        .build()

        when: "service recibe el request"
        def response = userService.createUser(userRequest)

        then: "service retorna un response no null"
        response != null
        response.isactive == "yes"

    }
}
