package dto.music_band;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CoordinatesDto implements Serializable {
    private Double x;
    private Double y;
}
