package dto.music_band.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthUserView implements Serializable {
    private String username;
    private String token;
}
