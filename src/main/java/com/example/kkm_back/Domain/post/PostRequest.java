package com.example.kkm_back.Domain.post;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    private Long id;
    private Long title;
    private String content;
    private String writer;
    private Boolean noticeYn;
}
