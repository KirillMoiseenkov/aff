package com.aff.aff.service;

import com.aff.aff.model.Audio;
import com.aff.aff.repository.AudioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AudioService {
    @Autowired
    private final AudioRepo audioRepo;

    public Audio getById(Long id){
        return audioRepo.findById(id).orElseThrow();
    }

    public Audio findByPlaylist(Long playlistId, String name){
        return audioRepo.findByPlaylistIdAndName(playlistId, name);
    }

    public void saveAudio(Audio audio) {
        audioRepo.save(audio);
    }
}
