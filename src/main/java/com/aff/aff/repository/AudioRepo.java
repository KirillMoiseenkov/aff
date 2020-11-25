package com.aff.aff.repository;

import com.aff.aff.model.Audio;
import com.aff.aff.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AudioRepo extends JpaRepository<Audio, Long> {
    Audio findByPlaylistIdAndName(Long playlistId, String name);
}
