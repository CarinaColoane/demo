package cl.example.demoBCI.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    private int number;

    private int cityCode;

    private int countryCode;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "fk_user_email", referencedColumnName="id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserInfo userId;

}
