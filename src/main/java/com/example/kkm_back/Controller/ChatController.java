package com.example.kkm_back.Controller;

import com.example.kkm_back.Domain.ChatRoom;
import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.Service.AwsS3Service;
import com.example.kkm_back.Service.ChatService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;
    @Autowired
    private AwsS3Service awsS3Service;

    @PostMapping
    public ChatRoom createRoom(@RequestParam(value = "userId", required = true) String userId) {
        return chatService.createRoom(userId);
    }
//    @GetMapping
//    public List<ChatRoom> findAllRoom() {
//        return chatService.findAllRoom();
//    }

    @GetMapping
    public ChatRoom findRoomById(@RequestParam(value = "roomId", required = true) String roomId) {
        return chatService.findRoomByRoomId(roomId);
    }
    @PostMapping("/files")
    public List<String> img(@RequestPart List<MultipartFile> multipartFile) {
        List<String> img = awsS3Service.uploadFile(multipartFile);
        List<String> return_img = new ArrayList<>();
        for (int i = 0; i < img.size(); i++) {
            return_img.add(img.get(i));
        }
        return return_img;
    }


}