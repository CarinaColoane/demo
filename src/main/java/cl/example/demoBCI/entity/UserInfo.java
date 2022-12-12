package cl.example.demoBCI.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @CreationTimestamp
    @JsonFormat(pattern="dd-MM-yyy")
    private LocalDate created;

    @UpdateTimestamp
    @JsonFormat(pattern="dd-MM-yyy")
    private LocalDate modified;

    @CreationTimestamp
    @JsonFormat(pattern="dd-MM-yyy")
    private LocalDate lastLogin;

    private String token;

    private boolean isActive;

    private String email;

    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(mappedBy = "userId",
            cascade = CascadeType.ALL)
    private List<UserPhone> phones;



}
