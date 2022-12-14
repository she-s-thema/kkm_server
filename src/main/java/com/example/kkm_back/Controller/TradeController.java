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
        return trade.getTrade_id();
    }

    @ResponseBody
    @RequestMapping(value = "/trade/makesecond", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public long tradesecond(@ModelAttribute Trade trade) throws Exception {
        tradeDAO.tradeInsert(trade);
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

    @ResponseBody
    @RequestMapping(value = "traded/finish/{trade_id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public String tradedFinish(@PathVariable("trade_id")long trade_id) throws Exception{
        tradeRepository.finishTraded(trade_id);
        return "trade finished";
    }
    @ResponseBody
    @RequestMapping(value = "trader/finish/{trade_id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public String traderFinish(@PathVariable("trade_id")long trade_id)throws Exception{
        tradeRepository.finishTrader(trade_id);
        return "trade finished";
    }
    @ResponseBody
    @RequestMapping(value = "trade/isTrading/{post_id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public boolean isTraded(@PathVariable("post_id")long post_id)throws Exception {
        long value = tradeRepository.isTrading(post_id);
        if(value>=1){
            return true;
        }
        else return false;
    }
    @ResponseBody
    @RequestMapping(value = "trade/finishall/{trade_id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public boolean isFinished(@PathVariable("trade_id")long trade_id)throws Exception{
            long value = tradeRepository.tradeFinished(trade_id);
            if(value>=1){
                return true;
            }
            else return false;
        }
    @ResponseBody
    @RequestMapping(value = "trade/update", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public String updateTrade( @Param("trade_id")long trade_id,@Param("trade_cost")long trade_cost, @Param("start_time")java.sql.Timestamp start_time, @Param("expired_time")java.sql.Timestamp expired_time) throws Exception{
        tradeRepository.tradeUpdate(trade_id,trade_cost,start_time,expired_time);
        return "success";
    }

//    @ResponseBody
//    @RequestMapping(value = "trade/getTraded", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
//    public long getTraded(@Param("post_id")long post_id,@Param("user_id")long user_id)throws Exception{
//        return tradeRepository.getTraded(post_id, user_id);
//    }

}
