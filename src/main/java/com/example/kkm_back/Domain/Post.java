package com.example.kkm_back.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Post {
    private long post_id;
    private long post_owner_id;
    private String image_1;
    private String image_2;
    private String image_3;
    private String description;
    private String write_time;
    private long cost;
    private double lat;
    private double lon;
    private String address;


    public Post(long post_id, long post_owner_id, String image_1, String image_2, String image_3, String description, String write_time, long cost,double lat,double lon,String address) {
        this.post_id = post_id;
        this.post_owner_id = post_owner_id;
        this.image_1 = image_1;
        this.image_2 = image_2;
        this.image_3 = image_3;
        this.description = description;
        this.write_time = write_time;
        this.cost = cost;
        this.lat = lat;
        this.lon = lon;
        this.address=address;
    }
}