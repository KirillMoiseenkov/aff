package com.aff.aff.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "audio")
@Data
public class Audio {
    @Id
    @ApiModelProperty("Id сущности")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @ApiModelProperty("иия записи")
    private String name;

    @Column(name = "path")
    @ApiModelProperty("путь к файлу")
    private String path;

    @Column(name = "audio_text")
    @ApiModelProperty("текст записи")
    private String audioText;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "playlist_id")
    @JsonBackReference
    @ApiModelProperty("Вопрос")
    private Playlist playlist;

    @Column(name = "mime_type")
    @ApiModelProperty("тип контента")
    private String mime;

}
