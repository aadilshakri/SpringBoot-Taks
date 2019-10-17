package com.stackroute.Music.services;

import com.stackroute.Music.exceptions.TrackAlreadyExistsException;
import com.stackroute.Music.exceptions.TrackNotFoundException;
import com.stackroute.Music.model.Track;


import java.util.List;
import java.util.Optional;

public interface TrackService {

    public Track addTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks() throws TrackNotFoundException;

    public Optional<Track> getTrackById(int trackId) throws TrackNotFoundException;

    public Track getTrackByName(String trackName) throws TrackNotFoundException;

    public String deleteTrack(int trackId) throws TrackNotFoundException;

    public Track updateComments(Track track) throws TrackNotFoundException;

}
