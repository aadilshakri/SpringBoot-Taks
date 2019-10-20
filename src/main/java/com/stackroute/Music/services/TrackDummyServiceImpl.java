package com.stackroute.Music.services;

import com.stackroute.Music.dao.TrackRepository;
import com.stackroute.Music.exceptions.TrackAlreadyExistsException;
import com.stackroute.Music.exceptions.TrackNotFoundException;
import com.stackroute.Music.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Qualifier("trackServiceImplDummy")
@Primary
@Service
public class TrackDummyServiceImpl implements TrackService {

    @Autowired
    TrackRepository trackRepository;
    @Override
    public Track addTrack(Track track) throws TrackAlreadyExistsException {

        if(trackRepository.existsById( track.getTrackId() ) ){
            throw new TrackAlreadyExistsException("Track already exists!");
        }
        trackRepository.save(track);
        return track;
    }

    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException {
        List<Track> trackList = trackRepository.findAll();
        if(trackList.size() == 0){
            throw new TrackNotFoundException("No Tracks found!");
        }
        return trackList;

    }

    @Override
    public Optional<Track> getTrackById(int trackId) throws TrackNotFoundException {
        if(trackRepository.existsById(trackId) == false){
            throw new TrackNotFoundException("Track not found!");
        }
        return trackRepository.findById(trackId);
    }

    @Override
    public Track getTrackByName(String trackName) throws TrackNotFoundException {
        if(trackRepository.findByTrackName(trackName) == null){
            throw new TrackNotFoundException("Track not found!");
        }
        return trackRepository.findByTrackName(trackName);
    }

    @Override
    public String deleteTrack(int trackId) throws TrackNotFoundException{
        if(trackRepository.existsById(trackId) == false){
            throw new TrackNotFoundException("Track not found!");
        }
        trackRepository.deleteById(trackId);
        return "Deleted";
    }

    @Override
    public Track updateComments(Track track) throws TrackNotFoundException {
        if(trackRepository.existsById(track.getTrackId()) == false){
            throw new TrackNotFoundException("Track not found!");
        }
        trackRepository.save(track);
        return track;
    }
}
