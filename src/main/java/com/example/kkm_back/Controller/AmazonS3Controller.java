package com.example.kkm_back.Controller;

import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.Repository.PostRepository;
import com.example.kkm_back.Service.AwsS3Service;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/s3",produces = "application/json; charset=utf-8")
public class AmazonS3Controller {

    @Autowired
    private AwsS3Service awsS3Service;
    @Autowired
    private PostRepository postRepository;


    //파라미터에 포스트아이디 값 넣어주고 바디 폼데이터에 사진 넣어줌
    @ApiOperation(value = "Amazon S3에 파일 업로드", notes = "Amazon S3에 파일 업로드 ")
    @PutMapping("/file")
    public Post uploadFile(@Param("post_id")long post_id, @RequestPart List<MultipartFile> multipartFile ) {
        List<String> arr =awsS3Service.uploadFile(multipartFile);
        for(int i=0;i<arr.size();i++){
            String st_i = Integer.toString(i+1);
            String image="image_"+st_i;
            postRepository.uploadFile(post_id,arr.get(i),image);
        }

        return postRepository.getPostID(post_id);


    }

}

