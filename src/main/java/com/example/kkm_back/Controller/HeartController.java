package com.example.kkm_back.Controller;

import com.example.kkm_back.DAO.HeartDAO;
import com.example.kkm_back.Domain.Heart;
import com.example.kkm_back.Repository.HeartRepository;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class HeartController {
    @Autowired
    private HeartRepository heartRepository;

    @Autowired
    private HeartDAO heartDAO;

    @ApiOperation(value = "하트 누르기", notes = "하트 누루기")
    @ResponseBody
    @RequestMapping(value = "/heart", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public long Heart(@ModelAttribute Heart heart) throws Exception {
        heartDAO.heartInsert(heart);
        System.out.println(heart.getHeart_id());
        return heart.getHeart_id();

    }
    @ApiOperation(value = "해당 게시물의 하트 개수", notes = "해당 게시물의 하트 개수")
    @ResponseBody
    @RequestMapping(value = "/heart/{post_id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public int CountHeart(@PathVariable("post_id") long post_id) throws Exception {
        return heartRepository.getHeartCount(post_id);

    }
    @ApiOperation(value = "하트 취소", notes = "하트 취소")
    @ResponseBody
    @RequestMapping(value = "/heart/cancel/{heart_id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public String CancelHeart(@PathVariable("heart_id") int heart_id) throws Exception {
        heartRepository.CancelHeart(heart_id);
        return "success";
    }

    @ApiOperation(value = "다시 하트 누르기", notes = "다시 하트 누르기")
    @ResponseBody
    @RequestMapping(value = "/heart/re/{heart_id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public String ReHeart(@PathVariable("heart_id") int heart_id) throws Exception {
        heartRepository.ReHeart(heart_id);
        return "success";
    }

    @ApiOperation(value = "모든하트(for TEST)", notes = "모든하트(for TEST)")
    @ResponseBody
    @RequestMapping(value = "/heartlist", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<Heart> ReHeart() throws Exception {
        return heartRepository.getAllHeart();
    }
    @ApiOperation(value = "", notes = "모든하트(for TEST)")
    @ResponseBody
    @RequestMapping(value = "/getHeartNum", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public boolean trueorfalse(@Param("user_id") long user_id, @Param("post_id") long post_id) throws Exception {
        int trueorfalse;
        boolean Trueorfalse;
        trueorfalse = heartRepository.trueOrFalse(user_id, post_id);
        if (trueorfalse > 0) {
            Trueorfalse = true;
        } else {
            Trueorfalse = false;
        }
        return Trueorfalse;
    }

    @ResponseBody
    @RequestMapping(value = "/jjamList", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<Map<String, Object>> getjjamList(@Param("user_id") long user_id) throws Exception {
        return heartRepository.jjamList(user_id);
    }
}
