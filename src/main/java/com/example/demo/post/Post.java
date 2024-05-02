package com.example.demo.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "post")
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("dbId")
    private Long id;
    private String slug;
    private String url;
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;
    private String image;
    private String thumbnail;
    private String status;
    private String category;
    private String publishedAt;
    private String updatedAt;
    private String userId;

    @JsonProperty("id")
    private Long remoteDbId;


}
