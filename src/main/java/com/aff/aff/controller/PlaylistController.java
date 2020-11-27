package com.aff.aff.controller;

import com.aff.aff.model.Playlist;
import com.aff.aff.service.PlaylistService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
@RequiredArgsConstructor
public class PlaylistController {

    @Autowired
    private final PlaylistService playlistService;

    @GetMapping(value = "/get/random/list")
    @ApiOperation(value = "Получить случайный плейлист")
    public Playlist getRandomPlaylist(){
       return playlistService.getRandomPlaylist();
    }

    @GetMapping(value = "/get/random/{name}")
    @ApiOperation(value = "Получить случайный по имени")
    public Playlist getRandomPlaylist(@PathVariable(name = "name") String name){
        return playlistService.findRandomByName(name);
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "Создать плейлист")
    public void createPlaylist(@RequestBody Playlist playlist) {
       playlistService.savePlaylist(playlist);
    }

    @GetMapping(value = "/get/all")
    @ApiOperation(value = "Поулчить все плейлисты")
    public List<Playlist> getAllPlaylist(){
        return playlistService.getAll();
    }
}
