package com.example.kkm_back.Controller;


import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.Domain.User;
import com.example.kkm_back.Repository.PostRepository;
import com.sun.jdi.event.ExceptionEvent;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;


    @PostMapping("/post")
    public String Post(@ModelAttribute Post post) throws Exception {
        postRepository.insertPost(post);
        return "success";
    }

    @GetMapping("/postlist")
    public List<Post> getAll() throws Exception {
        return postRepository.getAll();
    }

    @GetMapping("/post/{post_owner_id}")
    public List<Post> getPost(@PathVariable("post_owner_id") String post_owner_id) {
        return postRepository.getPost(post_owner_id);
    }



    @GetMapping(value = "post/townlist")//lon lat 값 넣어주면 댐요
    public List<Post> getTown(@Param("lon")String lon, @Param("lat")String lat) throws Exception{
        return postRepository.getTown(lon,lat);
    }

}

