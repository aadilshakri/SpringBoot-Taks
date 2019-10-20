package com.stackroute.Music.controller;

import com.stackroute.Music.exceptions.TrackAlreadyExistsException;
import com.stackroute.Music.exceptions.TrackNotFoundException;
import com.stackroute.Music.model.Track;
import com.stackroute.Music.services.TrackService;
import com.stackroute.Music.exceptions.TrackAlreadyExistsException;
import com.stackroute.Music.exceptions.TrackNotFoundException;
import com.stackroute.Music.model.Track;
import com.stackroute.Music.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RequestMapping("/api")
@RestController
public class TrackController {
    @Autowired
    TrackService trackService;

    @PostMapping("/track")
    public ResponseEntity<?> addTrack(Track track){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<Track>(trackService.addTrack(track), HttpStatus.CREATED);
        }catch (TrackAlreadyExistsException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/track")
    public ResponseEntity<?> getAllTracks(){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity< List<Track> >(trackService.getAllTracks(),HttpStatus.CREATED);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/id/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable int trackId){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<Optional<Track>>(trackService.getTrackById(trackId), HttpStatus.CREATED);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/track/{trackName}")
    public ResponseEntity<?> getTrackByName(@PathVariable String trackName){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<Track>(trackService.getTrackByName(trackName),HttpStatus.CREATED);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/track/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId){
        ResponseEntity responseEntity;
        try{
            trackService.deleteTrack(trackId);
            responseEntity = new ResponseEntity<String>("Deleted",HttpStatus.CREATED);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/track")
    public ResponseEntity<?> updateComments(Track track){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<Track>(trackService.updateComments(track),HttpStatus.OK);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}