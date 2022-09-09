package com.example.kkm_back.Controller;

import com.example.kkm_back.Domain.ChatRoom;
import com.example.kkm_back.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

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
}