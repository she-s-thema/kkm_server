package com.example.kkm_back.Controller;


import com.example.kkm_back.DAO.TradeDAO;
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

    @Autowired
    private TradeDAO tradeDAO;

    @ResponseBody
    @RequestMapping(value = "/trade/makefirst", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public long tradefirst(@ModelAttribute Trade trade) throws Exception {
        tradeDAO.tradeInsert(trade);
        System.out.println(trade.getTrade_id());
        return trade.getTrade_id();
    }

    @ResponseBody
    @RequestMapping(value = "/trade/makesecond", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public long tradesecond(@ModelAttribute Trade trade) throws Exception {
        tradeDAO.tradeInsert(trade);
        System.out.println(trade.getTrade_id());
        return trade.getTrade_id();
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


}
