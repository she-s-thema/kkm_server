package com.example.kkm_back.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private String user_id;
    private String nickname;
    private String k_id;
    private String k_img_url;
    private double lat;
    private double lon;
    private String address;


    public User(String user_id, String nickname, String k_id, String k_img_url, double lat,  double lon, String address) {
        this.user_id = user_id;
        this.k_id = k_id;
        this.nickname = nickname;
        this.k_img_url = k_img_url;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
    }
}
