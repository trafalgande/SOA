package dto.music_band.request;

import dto.music_band.CoordinatesDto;
import dto.music_band.LabelDto;
import dto.music_band.MusicGenreDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
public class CreateMusicBandRequest implements Serializable {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private CoordinatesDto coordinates;

    @Positive
    @NotNull
    private long numberOfParticipants;

    @NotNull
    private String description;

    @NotNull
    private MusicGenreDto genre;

    @NotNull
    private LabelDto label;
}
