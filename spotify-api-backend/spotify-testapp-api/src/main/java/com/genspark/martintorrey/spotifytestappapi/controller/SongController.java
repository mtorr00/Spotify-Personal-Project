package com.genspark.martintorrey.spotifytestappapi.controller;


import com.genspark.martintorrey.spotifytestappapi.model.Song;
import com.genspark.martintorrey.spotifytestappapi.services.SongService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SongController {
    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping("/songs")
    public Song fetchSong(@RequestBody Song song) {
        return songService.createSong(song);
    }
}
