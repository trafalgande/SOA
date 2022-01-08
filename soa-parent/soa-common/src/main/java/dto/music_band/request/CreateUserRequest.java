package dto.music_band.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Data
public class CreateUserRequest implements Serializable {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
    private Set<String> authorities;
}