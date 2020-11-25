package com.aff.aff.service;

import com.aff.aff.model.Audio;
import com.aff.aff.model.Playlist;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileService {
    @Autowired
    private final VideoStreamService videoStreamService;

    @Autowired
    private final AudioService audioService;

    private static String PATH = "/Users/kirillmoiseenkov/Desktop/file_uploader/";

    public String saveFile(String fileName, MultipartFile file, Long playlistId) {
        Audio audio = new Audio();
        audio.setName(fileName);
        audio.setMime(file.getContentType());

        Playlist playlist = new Playlist();
        playlist.setId(playlistId);

        audio.setPlaylist(playlist);

        String path = PATH + fileName;

        audio.setPath(path);

        try (FileOutputStream fos = new FileOutputStream(path)) {
            byte[] buffer = file.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        audioService.saveAudio(audio);
        return path;
    }
}
