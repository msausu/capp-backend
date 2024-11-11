package sa.m.ntd.calculator.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class CalculatorUser {

    @Id
    @Size(min = 6, max = 200)
    @Email
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Size(min = 8, max = 2048)
    @Pattern(regexp = "^\\p{Alnum}+$")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private String status;
}
