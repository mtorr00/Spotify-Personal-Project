package com.genspark.martintorrey.spotifytestappapi.apiControllers;

import com.genspark.martintorrey.spotifytestappapi.model.Song;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class ClientCredentialsController {
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
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            System.out.println("Expires in: " + clientCredentials.getExpiresIn());

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void clientCredentials_Async() {
        try{
            final CompletableFuture<ClientCredentials> clientCredentialsFuture = clientCredentialsRequest.executeAsync();
            //Thread free to do other tasks

            //Example Only, never block in production code
            final ClientCredentials clientCredentials = clientCredentialsFuture.join();

            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            System.out.println("Expires in: " + clientCredentials.getExpiresIn());
        } catch(CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        } catch(CancellationException e) {
            System.out.println("Async operation cancelled.");
        }
    }


    public static void getTrackSearchResults_Sync(String searchQuery) {
        SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(searchQuery)
                //.market(CountryCode.US)
                .limit(1)
                .offset(0)
                .build();
        try{
            final Paging<Track> trackPaging = searchTracksRequest.execute();
            System.out.println("Total: " + trackPaging.getTotal());
            Track[] trackArray = trackPaging.getItems();
            Track track = trackArray[0];
            Song song = new Song();
            song.setSongName(track.getName());
            song.setAlbumName(track.getAlbum().getName());
            ArtistSimplified[] artists = track.getArtists();
            ArtistSimplified firstArtists = artists[0];
            song.setArtistName(firstArtists.getName());
            System.out.println(song);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
