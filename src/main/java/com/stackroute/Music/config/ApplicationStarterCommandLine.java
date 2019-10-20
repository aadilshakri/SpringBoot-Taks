package com.stackroute.Music.config;

import com.stackroute.Music.dao.TrackRepository;
import com.stackroute.Music.model.Track;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationStarterCommandLine {

    @Bean
    public CommandLineRunner loadData(TrackRepository trackRepository) {
        return (args) -> {
            trackRepository.save(new Track(31, "22", "Swift"));
        };
    }
}
