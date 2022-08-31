package com.example.kkm_back.Controller;


import com.example.kkm_back.Domain.Post;
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
    @GetMapping("/post/{users.user_id}/{Post.post_id}")//다중 파라미터 오류 일단 스킵 함
    public List<Double> getLAT(@Param("users.user_id")String user_id,@Param("Post.post_id")String post_id) throws Exception{
        return postRepository.getLAT1(user_id,post_id);
    }
    @GetMapping("/post/town/{users.user_id}/")//다중 파라미터 오류 일단 스킵 함
    public List<Double> getLAT(@Param("users.user_id")String user_id) throws Exception{
        return postRepository.getLAT(user_id);
    }
//    @GetMapping("post/town/list")
//    public List<Post> getPostTown(@Param())
}

