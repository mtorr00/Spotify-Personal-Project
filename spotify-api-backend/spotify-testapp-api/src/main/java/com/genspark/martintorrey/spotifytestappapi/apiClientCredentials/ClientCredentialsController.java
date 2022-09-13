package com.genspark.martintorrey.spotifytestappapi.apiClientCredentials;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

import java.io.IOException;

public class ClientCredentials {
    private static final String clientId = "";
    private static final String clientSecret = "";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build();
    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
            .build();
    public static void clientCredentials_Sync() {
        try{
            final se.michaelthelin.spotify.model_objects.credentials.ClientCredentials clientCredentials = clientCredentialsRequest.execute();


        } catch (IOException | SpotifyWebApiException | ParseException e) {

        }
    }

}
