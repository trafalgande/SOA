package se.ifmo.pepe.soa2;

import dto.music_band.request.AddSingleRequest;
import dto.music_band.response.MusicBandView;
import se.ifmo.pepe.soa2.service.SoaService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("/grammy")
@RequestScoped
public class BandResource  {

    @Inject
    private SoaService service;

    @POST
    @Path("/band/{band-id}/singles")
    @Consumes(MediaType.APPLICATION_JSON)
    public MusicBandView addSingleToBand(@PathParam("band-id") long bandId,
                                         AddSingleRequest request) {
        return service.addSingleToBand(bandId, request);
    }

    @DELETE
    @Path("/band/{band-id}/participants")
    public MusicBandView removeParticipants(@PathParam("band-id") long bandId) {
        return service.removeParticipantFromBand(bandId);
    }
}
