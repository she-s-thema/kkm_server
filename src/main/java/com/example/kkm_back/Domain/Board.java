package com.example.kkm_back.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Board {

    private long id;
    private String title;
    private String content;


    public Board(long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
}

