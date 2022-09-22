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

    @ResponseBody
    @RequestMapping(value = "trade/finish/{trade_id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public String tradeFinish(@PathVariable("trade_id")long trade_id) throws Exception{
        tradeRepository.finishTrade(trade_id);
        return "trade finished";
    }

}
//
//    우리 프로젝트 시스템 상 교환하는 약속 1개 다시 돌려주는 약속 1개 총 약속 두 개를 잡습니다.
//        거래 완료 표시를
//        약속 두 개가 끝나고 두 거래자 모두 거래 완료를 눌렀을 때
//        표시한다는 가정 하에
//        두 명 다 Trade - trade_state에 완료를 넣습니다.
//        그 다음 각각의 약속 아이디 두 개와 각각의 사용자 이름과 거래 테이블의 trade_state가 완료라면
//        서로가 서로에게 리뷰권한을 줄 수 있게 하는것이 어떨까요?
//        리뷰 권한 테이블을 따로 만들고 다시.. 입렵받고... 있으면 리뷰 받고... 이런식으로...
//
