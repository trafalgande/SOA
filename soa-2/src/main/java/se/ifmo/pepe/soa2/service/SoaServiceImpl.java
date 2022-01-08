package se.ifmo.pepe.soa2.service;

import dto.music_band.request.AddSingleRequest;
import dto.music_band.response.MusicBandView;
import service.SoaServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.Objects;

@RequestScoped
public class SoaServiceImpl implements SoaService {

    @EJB
    private SoaServiceRemote service;

    @Override
    public MusicBandView addSingleToBand(long bandId, AddSingleRequest request) {
        return service.addSingleToBand(bandId, Objects.requireNonNull(request.getTitle()));
    }

    @Override
    public MusicBandView removeParticipantFromBand(long bandId) {
        return service.removeParticipantFromBand(bandId);
    }
}

