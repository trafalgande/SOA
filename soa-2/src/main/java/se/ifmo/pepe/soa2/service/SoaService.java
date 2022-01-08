package se.ifmo.pepe.soa2.service;

import dto.music_band.request.AddSingleRequest;
import dto.music_band.response.MusicBandView;

import javax.enterprise.inject.Decorated;


public interface SoaService {
    MusicBandView addSingleToBand(long bandId, AddSingleRequest request);
    MusicBandView removeParticipantFromBand(long bandId);
}
