package com.example.kkm_back.Controller;


import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.DAO.PostDAO;
import com.example.kkm_back.Domain.PostList;
import com.example.kkm_back.Repository.PostRepository;
import com.example.kkm_back.Service.PostService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private PostService postService;

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
    @RequestMapping(value = "/getPostList", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<PostList> getAllWithHeart(@Param("lon") String lon, @Param("lat") String lat) throws Exception {
        return postRepository.getAllWithHeart(lon, lat);
    }

    @ResponseBody
    @RequestMapping(value = "/getPostInfo/{post_owner_id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<Map<String, Object>> getPost(@PathVariable("post_owner_id") String post_owner_id) {
        return postRepository.getPost(post_owner_id);
    }


    @ResponseBody
    @RequestMapping(value = "post/townlist", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<Post> getTown(@Param("lon") String lon, @Param("lat") String lat) throws Exception {
        return postRepository.getTown(lon, lat);
    }
    //알고리즘 아직 완성 안됨 => 배열 문제
    @ResponseBody
    @RequestMapping(value = "post/algo", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<Post> getAlgorithm(@Param("user_id")String user_id)throws Exception{
        return postService.getHeart(user_id);
    }

    @RequestMapping(value = "post/getDetail", method = RequestMethod.GET)
    public Map<String, Object> getDetail(@RequestParam long post_id) throws Exception {
        return postRepository.getPostDetail(post_id);
    }

    @RequestMapping(value = "post/updateStatetwo/{post_id}", method = RequestMethod.PUT)
    public String setState(@PathVariable("post_id") long post_id) throws Exception {
        postRepository.setStateTwo(post_id);
        return "success";
    }

    @RequestMapping(value = "post/updateStatethree/{post_id}", method = RequestMethod.PUT)
    public String setStatethree(@PathVariable("post_id") long post_id) throws Exception {
        postRepository.setStateThree(post_id);
        return "success";
    }

    @RequestMapping(value = "post/delete/{post_id}", method = RequestMethod.DELETE)
    public String deletePost(@PathVariable("post_id") long post_id) throws Exception {
        postRepository.deletePost(post_id);
        return "sucess";
    }
}

