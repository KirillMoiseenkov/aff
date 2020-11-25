package com.aff.aff.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlist")
@Data
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Id плейлиста")
    private Long id;

    @Column(name = "name")
    @ApiModelProperty("название плейлиста")
    private String name;

    @OneToMany(mappedBy = "playlist", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    @ApiModelProperty("Список записей в плейлисте")
    private List<Audio> audio = new ArrayList<>();
}
