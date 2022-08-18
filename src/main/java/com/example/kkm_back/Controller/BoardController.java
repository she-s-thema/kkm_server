package com.example.kkm_back.Controller;

import com.example.kkm_back.Domain.Board;
import com.example.kkm_back.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    @RequestMapping(value = "/test")
    public String Test(@ModelAttribute Board board) throws Exception{
        boardRepository.insertTest(board);
        return "success";
    }
}
