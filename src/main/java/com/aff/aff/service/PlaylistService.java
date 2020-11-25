package com.aff.aff.service;

import com.aff.aff.model.Playlist;
import com.aff.aff.repository.PlaylistRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    @Autowired
    private final PlaylistRepo playlistRepo;

    public List<Playlist> findByName(String name){
        return playlistRepo.findByName(name);
    }

    public Playlist getRandomPlaylist(){
        return playlistRepo.getRandomPlaylist();
    }

    public Playlist findRandomByName(String name) {
        return playlistRepo.findRandomByName(name);
    }

    public void savePlaylist(Playlist playlist) {
        playlistRepo.save(playlist);
    }
}
