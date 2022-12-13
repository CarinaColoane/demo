package cl.example.demoBCI.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_phone")
public class UserPhone {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    private String id;
    //@Pattern(regexp = "[0-9]{8}", message = "Enter the 8 phone numbers")
    private String number;

    //@Pattern(regexp = "[0-9]{1}", message = "Enter the city code number")
    private String cityCode;

    //(regexp = "[0-9]{2}", message = "Enter the 2 country code numbers")
    private String countryCode;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference
    private UserInfo userId;

}
