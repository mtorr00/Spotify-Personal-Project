package com.genspark.martintorrey.spotifytestappapi.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "songs")
public class SongEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String songName;
    private String albumName;
    private String artistName;
    private String spotId;
    private String spotImageUrl;
}
