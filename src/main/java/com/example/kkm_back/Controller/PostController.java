package com.example.kkm_back.Controller;


import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.Repository.PostRepository;
import com.sun.jdi.event.ExceptionEvent;
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

    public Map<String,Post> postMap;

    @PostMapping("/post")
    public String Post(@ModelAttribute Post post) throws Exception{
        postRepository.insertPost(post);
        return "success";
    }

    @GetMapping("/postlist")
    public List<Post> getAll(){
        return postRepository.getAll();
    }
    @GetMapping("/post/{post_owner_id}")
    public Post getPost(@PathVariable("post_owner_id") String post_owner_id){
        return postRepository.getPost(post_owner_id);
    }
}

