package cl.example.demoBCI.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserRequestTO {
    @NotBlank(message = "Ingrese nombre")
    private String name;
    @NotBlank(message = "Ingrese correo")
    @Email
    private String email;
    @NotBlank(message = "Ingrese contraseña")
    @Pattern(regexp = "[a-zA-Z0-9]{8}", message = "contraseña no cumple formato")
    private String password;
    @NotBlank(message = "Ingrese telefono")
    private List<PhoneTO> phones;
}
