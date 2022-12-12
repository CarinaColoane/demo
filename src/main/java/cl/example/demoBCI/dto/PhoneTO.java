package cl.example.demoBCI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PhoneTO {

    @NotBlank(message = "Ingrese numero de telefono")
    @Pattern(regexp = "[0-9]{8}", message = "Ingrese los 8 numeros")
    private String number;

    @NotBlank(message = "Ingrese codigo ciudad de telefono")
    @Pattern(regexp = "[0-9]{1}", message = "Ingrese 1 numero")
    private String citycode;

    @NotBlank(message = "Ingrese codigo pais de telefono")
    @Pattern(regexp = "[0-9]{2}", message = "Ingrese los 2 numeros")
    private String countrycode;

}
