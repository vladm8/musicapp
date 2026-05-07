package com.example.musicapp.service;

import com.example.musicapp.model.Artist;
import com.example.musicapp.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Artist getArtistById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    public List<Artist> getArtistsByGenre(String genre) {
        return artistRepository.findByGenre(genre);
    }

    public Artist updateArtist(Long id, Artist newData) {
        Artist artist = artistRepository.findById(id).orElse(null);
        if (artist == null) {
            return null;
        }
        artist.setName(newData.getName());
        artist.setCountry(newData.getCountry());
        artist.setGenre(newData.getGenre());
        artist.setDebutYear(newData.getDebutYear());
        return artistRepository.save(artist);
    }

    public boolean deleteArtist(Long id) {
        if (!artistRepository.existsById(id)) {
            return false;
        }
        artistRepository.deleteById(id);
        return true;
    }
}
