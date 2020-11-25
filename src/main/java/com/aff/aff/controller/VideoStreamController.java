package com.aff.aff.controller;

import com.aff.aff.service.VideoStreamService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoStreamController {

    @Autowired
    private final VideoStreamService videoStreamService;

    @GetMapping("/stream/{fileName}/{playlistId}")
    @ApiOperation(value = "Получить аудио файл по Id плейлиста")
    public Mono<ResponseEntity<byte[]>> getFileStream(@RequestHeader(value = "Range", required = false) String httpRangeList,
                                                      @PathVariable("fileName") String fileName,
                                                      @PathVariable("playlistId") Long playlistId) {
        return Mono.just(videoStreamService.prepareContent(fileName, httpRangeList, playlistId));
    }
}
