package com.example.kkm_back.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ArticleCreateDTO {

    private long post_id;
    private long post_owner_id;
    private String title;
    private String image_1;
    private String image_2;
    private String image_3;
    private String description;
    private java.sql.Timestamp write_time;
    private long cost;
    private long state;
    private long type;
    }

