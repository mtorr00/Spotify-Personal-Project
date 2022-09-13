package com.genspark.martintorrey.spotifytestappapi.services;

import com.genspark.martintorrey.spotifytestappapi.entity.SongEntity;
import com.genspark.martintorrey.spotifytestappapi.model.Song;
import com.genspark.martintorrey.spotifytestappapi.repository.SongRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService{

    private SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song createSong(Song song) {
        SongEntity songEntity = new SongEntity();
        BeanUtils.copyProperties(song, songEntity);
        songRepository.save(songEntity);
        return song;
    }
}
