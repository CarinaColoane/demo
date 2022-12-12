package cl.example.demoBCI.dto

import cl.example.demoBCI.dto.UserRequestTO
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import spock.lang.Specification
import spock.lang.Title

@Title("Esta especificación prueba ...")
class UserRequestTOSpec extends Specification {
    private String name = "Juan Rodriguez";
    private String email = "juan@rodriguez.org";
    private String password = "hunter2";

    private String number = "1234567";
    private String citycode =  "1";
    private String countrycode = "57"

    private String phones = '';

    def setup() {
        //
    }

    def getValidator () {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.getValidator();
    }

    def "Email vacio debe retornar error" (){
        given: "El body request es"
        def requestBody = new UserRequestTO(name, "", password, phones)

        when: "No se cumple con el formato"
        def violations = getValidator().validate(requestBody)

        then: "Se detecta que el email es vacio"
        violations.size() == 1
    }


}
