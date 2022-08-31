package com.example.kkm_back.Controller;


import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.Domain.Trade;
import com.example.kkm_back.Repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TradeController {
    @Autowired
    private TradeRepository tradeRepository;

    @PostMapping("/trade")
    public String Trade(@ModelAttribute Trade trade) throws Exception {
        tradeRepository.insertTrade(trade);
        return "success";
    }
    @GetMapping("tradelist")
    public List<Trade> getAll() {
        return tradeRepository.getAll();
    }
    @GetMapping("tradelist/{post_owner_id}")
    public List<Trade> getTrade(@PathVariable("post_owner_id")String post_owner_id){
        return tradeRepository.getTrade(post_owner_id);
        }
    @PutMapping("/changeState/{trade_set}")
    public String updateTradeState(@PathVariable("trade_set")String trade_set)throws Exception{
        tradeRepository.tradeSet(trade_set);
        return "success";
    }

}
