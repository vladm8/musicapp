package com.example.musicapp.service;

import com.example.musicapp.model.Song;
import com.example.musicapp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song getSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    public List<Song> getSongsByAlbumId(Long albumId) {
        return songRepository.findByAlbumId(albumId);
    }

    public List<Song> getSongsByGenre(String genre) {
        return songRepository.findByGenre(genre);
    }

    public Song updateSong(Long id, Song newData) {
        Song song = songRepository.findById(id).orElse(null);
        if (song == null) {
            return null;
        }
        song.setTitle(newData.getTitle());
        song.setDurationSeconds(newData.getDurationSeconds());
        song.setGenre(newData.getGenre());
        song.setAlbumId(newData.getAlbumId());
        return songRepository.save(song);
    }

    public boolean deleteSong(Long id) {
        if (!songRepository.existsById(id)) {
            return false;
        }
        songRepository.deleteById(id);
        return true;
    }
}
