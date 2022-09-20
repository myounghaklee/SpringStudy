package keepingMemory.interfaces;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
public class UserDto {
    private UserDto(){}

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class LoginRequest{
        @NotBlank
        private String email;
        private String password;
    }

}
