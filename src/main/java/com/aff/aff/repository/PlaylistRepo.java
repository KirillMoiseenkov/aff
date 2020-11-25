package com.aff.aff.repository;

import com.aff.aff.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaylistRepo extends JpaRepository<Playlist, Long> {
    List<Playlist> findByName(String name);

    @Query(value = "Select * from playlist order by random() limit 1", nativeQuery = true)
    Playlist getRandomPlaylist();

    @Query(value = "Select * from playlist where name = ?1 order by random() limit 1", nativeQuery = true)
    Playlist findRandomByName(String name);
}

