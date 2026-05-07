package com.example.musicapp.repository;

import com.example.musicapp.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findByGenre(String genre);

    List<Artist> findByCountry(String country);
}
