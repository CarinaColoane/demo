package cl.example.demoBCI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserResponseTO {

    private int id;
    private LocalDate created;
    private LocalDate modified;
    private LocalDate last_login;
    private int token;
    private String isactive;

}
