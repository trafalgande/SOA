package dto.music_band.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AddSingleRequest implements Serializable {
    @NotNull
    private String title;
}
