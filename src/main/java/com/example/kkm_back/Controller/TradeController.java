package com.example.kkm_back.Controller;


import com.example.kkm_back.Domain.Trade;
import com.example.kkm_back.Repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TradeController {
    @Autowired
    private TradeRepository tradeRepository;

    @PostMapping("/trade")
    public String Trade(@ModelAttribute Trade trade) throws Exception {
        tradeRepository.insertTrade(trade);
        return "success";
    }
    @PutMapping("/changeState/{trade_set}")
    public String updateTradeState(@PathVariable("trade_set")String trade_set)throws Exception{
        tradeRepository.updateTradeState(trade_set);
        return "success";
    }

}
