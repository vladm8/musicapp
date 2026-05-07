package com.example.musicapp.service;

import com.example.musicapp.model.Album;
import com.example.musicapp.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album addAlbum(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbumById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }

    public List<Album> getAlbumsByArtistId(Long artistId) {
        return albumRepository.findByArtistId(artistId);
    }

    public Album updateAlbum(Long id, Album newData) {
        Album album = albumRepository.findById(id).orElse(null);
        if (album == null) {
            return null;
        }
        album.setTitle(newData.getTitle());
        album.setReleaseYear(newData.getReleaseYear());
        album.setLabel(newData.getLabel());
        album.setArtistId(newData.getArtistId());
        return albumRepository.save(album);
    }

    public boolean deleteAlbum(Long id) {
        if (!albumRepository.existsById(id)) {
            return false;
        }
        albumRepository.deleteById(id);
        return true;
    }
}
