package com.example.kkm_back.Controller;

import com.example.kkm_back.Service.AwsS3Service;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/s3")
public class AmazonS3Controller {

    private final AwsS3Service awsS3Service;

    /**
     * Amazon S3에 파일 업로드
     * 성공 시 200 Success와 함께 업로드 된 파일의 파일명 리스트 반환
     */
    @ApiOperation(value = "Amazon S3에 파일 업로드", notes = "Amazon S3에 파일 업로드 ")
    @PostMapping("/file")
    public List<String> uploadFile(@ApiParam(value = "파일들(여러 파일 업로드 가능)", required = true) @RequestPart List<MultipartFile> multipartFile) {
        return awsS3Service.uploadFile(multipartFile);

    }

}

