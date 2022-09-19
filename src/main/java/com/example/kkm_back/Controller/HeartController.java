package com.example.kkm_back.Controller;

import com.example.kkm_back.Domain.Heart;
import com.example.kkm_back.Repository.HeartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HeartController {
    @Autowired
    private HeartRepository heartRepository;

    @ResponseBody
    @RequestMapping(value = "/heart", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public long Heart(@ModelAttribute Heart heart)throws Exception{
        return heartRepository.insertHeart(heart);

    }
    @ResponseBody
    @RequestMapping(value = "/heart/{post_id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public int CountHeart(@PathVariable("post_id")long post_id)throws Exception{
        return heartRepository.getHeartCount(post_id);

    }
    @ResponseBody
    @RequestMapping(value = "/heart/cancel/{heart_id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public String CancelHeart(@PathVariable("heart_id")int heart_id)throws Exception{
        heartRepository.CancelHeart(heart_id);
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = "/heart/re/{heart_id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public String ReHeart(@PathVariable("heart_id")int heart_id)throws Exception{
        heartRepository.ReHeart(heart_id);
        return "success";
    }
}
