package com.example.kkm_back.Controller;


import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.Repository.PostRepository;
import com.sun.jdi.event.ExceptionEvent;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value = "/post")
    public String Post(@ModelAttribute Post post) throws Exception{
        postRepository.insertPost(post);
        return "success";
    }

    @RequestMapping(value = "/postlist", method = RequestMethod.GET)
    public String Post(@ModelAttribute Post post) throws Exception{
        postRepository.getAllMessages();
        return
    }
}

