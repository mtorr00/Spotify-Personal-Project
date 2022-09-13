package com.genspark.martintorrey.spotifytestappapi.model;

import lombok.Data;

@Data
public class Song {

    private long id;

    private String songName;
    private String albumName;
    private String artistName;
}
