package service;

import dto.music_band.response.MusicBandView;
import org.glassfish.jersey.SslConfigurator;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

import static java.lang.String.format;

@Stateless
public class SoaServiceRemoteImpl implements SoaServiceRemote {

    @Override
    public MusicBandView addSingleToBand(long bandId, String title) {
        Invocation.Builder invocationBuilder = getSinglesWebTarget(bandId).request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.post(Entity.entity(title,
                MediaType.APPLICATION_JSON_TYPE));
        return response.readEntity(MusicBandView.class);
    }

    @Override
    public MusicBandView removeParticipantFromBand(long bandId) {
        Invocation.Builder invocationBuilder = getParticipantsWebTarget(bandId).request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.delete();
        return response.readEntity(MusicBandView.class);
    }

    private Client client() {
        SslConfigurator sslConfigurator = SslConfigurator.newInstance()
                .keyStoreFile("/Users/aleksey.chaika/Desktop/wildfly-18.0.1.Final/standalone/configuration/server.keystore")
                .keyStorePassword("secret")
                .trustStoreFile("/Users/aleksey.chaika/Desktop/wildfly-18.0.1.Final/standalone/configuration/server.keystore")
                .trustStorePassword("secret");

        return ClientBuilder.newBuilder()
                .sslContext(sslConfigurator.createSSLContext())
                .hostnameVerifier((hostname, sslSession) -> hostname.equals("localhost"))
                .build();
    }

    private WebTarget getSinglesWebTarget(long bandId) {
        WebTarget webTarget = Objects.requireNonNull(client()).target(root());
        return webTarget.path(format(singlesUrl(), bandId));
    }

    private WebTarget getParticipantsWebTarget(long bandId) {
        WebTarget webTarget = Objects.requireNonNull(client()).target(root());
        return webTarget.path(format(participantsUrl(), bandId));
    }

    private String root() {
        return "https://localhost:8080/api";
    }

    private String singlesUrl() {
        return "/music-bands/%d/singles";
    }

    private String participantsUrl() {
        return "/music-bands/%d/participants";
    }
}

