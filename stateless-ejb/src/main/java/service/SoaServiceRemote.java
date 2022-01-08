package service;

import dto.music_band.response.MusicBandView;

import javax.ejb.Remote;

@Remote
public interface SoaServiceRemote {
    MusicBandView addSingleToBand(long bandId, String title);
    MusicBandView removeParticipantFromBand(long bandId);
}
