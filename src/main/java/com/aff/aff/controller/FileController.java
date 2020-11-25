package com.aff.aff.controller;

import com.aff.aff.service.FileService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    @Autowired
    private final FileService fileService;

    @PostMapping("/save/{fileName}/{playlistId}")
    @ApiOperation("Сохранение файла")
    @ResponseStatus(HttpStatus.OK)
    public void saveFile(@RequestParam("file") MultipartFile uploadedFile,
                         @PathVariable("fileName") String fileName,
                         @PathVariable("playlistId") Long playlistId){
        fileService.saveFile(uploadedFile.getOriginalFilename(), uploadedFile,playlistId);
    }

}
