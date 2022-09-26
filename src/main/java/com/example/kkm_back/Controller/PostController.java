package com.example.kkm_back.Controller;


import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.DAO.PostDAO;
import com.example.kkm_back.Repository.PostRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostDAO postDAO;

    @ResponseBody
    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public long Post(@ModelAttribute Post post) throws Exception {
        postDAO.postInsert(post);
        return post.getPost_id();
    }

    @ResponseBody
    @RequestMapping(value = "/postlist", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<Post> getAll() throws Exception {
        return postRepository.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/post/{post_owner_id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<Post> getPost(@PathVariable("post_owner_id") String post_owner_id) {
        return postRepository.getPost(post_owner_id);
    }


    @ResponseBody
    @RequestMapping(value = "post/townlist", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<Post> getTown(@Param("lon") String lon, @Param("lat") String lat) throws Exception {
        return postRepository.getTown(lon, lat);
    }

    @RequestMapping(value = "post/getDetail", method = RequestMethod.GET)
    public Post getDetail(@RequestParam long post_id) throws Exception {
        return postRepository.getPostID(post_id);
    }
    @RequestMapping(value = "post/updateState/{post_id}", method = RequestMethod.PUT)
    public String setState(@PathVariable("post_id")long post_id)throws Exception{
        postRepository.setStateTwo(post_id);
        return "success";
    }

}

