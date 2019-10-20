package com.stackroute.Music.controller;

import com.stackroute.Music.dao.TrackRepository;
import com.stackroute.Music.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = { "classpath:application.properties" })

public class ApplicationStarter implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${track.id}")
    private int id;
    @Value("${track.trackname}")
    private String trackName;
    @Value("${track.comments}")
    private String comments;

    @Autowired
    private TrackRepository trackRepository;

    private void seedData() {

        Track track = new Track();
        track.setTrackId(id);
        track.setTrackName(trackName);
        track.setComments(comments);
        trackRepository.save(track);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        seedData();

    }
}