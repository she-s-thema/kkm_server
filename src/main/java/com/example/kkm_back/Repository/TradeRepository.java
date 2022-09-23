package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Trade;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TradeRepository {

    @Select("SELECT * FROM Trade")
    List<Trade> getAll();
    @Select("SELECT * FROM Trade WHERE post_owner_id=#{post_owner_id}")
    List<Trade> getTrade(@Param ("post_owner_id") String post_owner_id);


    @Update("update Trade set trade_state = 2 where trade_id=#{trade_id}")
    void finishTraded(@Param("trade_id")long trade_id);

    @Update("update Trade set trade_state_2 = 2 where trade_id=#{trade_id}")
    void finishTrader(@Param("trade_id")long trade_id);

//    @Select("\n" +
//            "select count(trade_id) from Trade\n" +
//            "inner join Post P on Trade.post_id = P.post_id\n" +
//            "inner join Users U on Trade.trader_id = U.user_id\n" +
//            "where P.post_id=#{post_id} and U.user_id=trader_id and U.user_id=#{user_id}")
//    long isTraded(@Param("post_id")long post_id,@Param("user_id")long user_id);

//    @Select("select trade_id from Trade\n" +
//            "inner join Post P on Trade.post_id = P.post_id\n" +
//            "inner join Users U on Trade.trader_id = U.user_id\n" +
//            "where P.post_id=#{post_id} and U.user_id=trader_id and U.user_id=#{user_id}")
//    long getTraded(@Param("post_id")long post_id,@Param("user_id")long user_id);

    @Select("select COUNT(trade_id) from Trade\n" +
            "inner join Users U on Trade.trader_id = U.user_id\n" +
            "inner join Post P on Trade.post_id = P.post_id\n" +
            "where trade_id=#{trade_id} and trade_state=2 and trade_state_2=2 and trade_th=2")
    long tradeFinished(@Param("trade_id")long trade_id);

}
