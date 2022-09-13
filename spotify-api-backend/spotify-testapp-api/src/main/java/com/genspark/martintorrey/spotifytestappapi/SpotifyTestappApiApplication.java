package com.genspark.martintorrey.spotifytestappapi;

import com.genspark.martintorrey.spotifytestappapi.apiClientCredentials.ClientCredentialsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotifyTestappApiApplication {

	public static void main(String[] args) {
		ClientCredentialsController.clientCredentials_Sync();
		SpringApplication.run(SpotifyTestappApiApplication.class, args);

	}

}
