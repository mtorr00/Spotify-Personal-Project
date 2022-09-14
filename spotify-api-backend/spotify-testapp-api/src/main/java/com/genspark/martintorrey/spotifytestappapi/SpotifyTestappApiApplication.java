package com.genspark.martintorrey.spotifytestappapi;

import com.genspark.martintorrey.spotifytestappapi.apiControllers.ClientCredentialsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpotifyTestappApiApplication {

	public static void main(String[] args) {
		ClientCredentialsController.clientCredentials_Sync();
		Scanner input = new Scanner(System.in);
		String searchQuery = input.nextLine();
		ClientCredentialsController.getTrackSearchResults_Sync(searchQuery);

		SpringApplication.run(SpotifyTestappApiApplication.class, args);

	}

}
