package com.example.kkm_back.Controller;

import com.example.kkm_back.Domain.Opinion;
import com.example.kkm_back.Repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class OpinionController {
    @Autowired
    private OpinionRepository opinionRepository;

    @ResponseBody
    @RequestMapping(value = "/sendOpinion", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String sendOpinion(Opinion opinion)throws Exception{
        opinionRepository.insertOp(opinion);
        return "success";
    }

}
