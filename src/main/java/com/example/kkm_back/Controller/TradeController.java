package com.example.kkm_back.Controller;


import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.Domain.Trade;
import com.example.kkm_back.Repository.TradeRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class TradeController {
    @Autowired
    private TradeRepository tradeRepository;

    @ResponseBody // trader_id null도 가능하게, auto 증가 되게
    @RequestMapping(value = "/trade",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String Trade(@ModelAttribute Trade trade) throws Exception {
        tradeRepository.insertTrade(trade);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/tradelist", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<Trade> getAll() {
        return tradeRepository.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "tradelist/{post_owner_id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<Trade> getTrade(@PathVariable("post_owner_id") String post_owner_id) {
        return tradeRepository.getTrade(post_owner_id);
    }

    @ResponseBody
    @RequestMapping(value = "/trade/makefirst", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String tradefirst(Trade trade) throws Exception {
        tradeRepository.insertTrade(trade);
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = "/trade/makesecond", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String tradesecond(Trade trade) throws Exception {
        tradeRepository.insertTrade(trade);
        return "success";
    }

}
