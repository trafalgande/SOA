package dto.music_band.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class AuthUserRequest implements Serializable {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
