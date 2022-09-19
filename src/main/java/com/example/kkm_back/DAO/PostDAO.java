package com.example.kkm_back.DAO;

import com.example.kkm_back.Domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostDAO {
    public List<Post> postList();
    public void postInsert(Post post);
}
