package com.stackroute.Music.dao;

import com.stackroute.Music.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    @Query("SELECT m FROM Track m WHERE m.trackName = ?1")
    Track findByTrackName(String trackName);
}
