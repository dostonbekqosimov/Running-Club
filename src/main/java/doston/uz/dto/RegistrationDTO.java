package doston.uz.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {
    private Long id;
    @NotEmpty(message = "Username should not be empty")
    private String username;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;
}
