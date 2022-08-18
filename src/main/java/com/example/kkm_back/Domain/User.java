package com.example.kkm_back.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private String user_id;
    private String nickname;
    private String k_id;
    private String k_img_url;
    private String k_email;

    public User(String user_id, String nickname, String k_id, String k_img_url, String k_email) {
        this.user_id = user_id;
        this.k_id = k_id;
        this.nickname = nickname;
        this.k_img_url = k_img_url;
        this.k_email = k_email;
    }
}
