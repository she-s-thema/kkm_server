package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.Domain.Trade;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TradeRepository {
    @Insert("INSERT INTO Trade VALUES(#{trade_id}, #{post_id},#{post_owner_id},#{trader_id}, #{trade_cost},#{trade_state},#{start_time},#{expired_time})")
    void insertTrade(Trade trade);
    @Select("SELECT * FROM Trade")
    List<Trade> getAll();
    @Select("SELECT * FROM Trade WHERE post_owner_id=#{post_owner_id}")
    List<Trade> getTrade(@Param ("post_owner_id") String post_owner_id);

    @Insert("INSERT INTO Trade VALUES(#{trade_id}, #{post_id},#{post_owner_id},#{trader_id}, #{trade_cost},#{trade_state},#{start_time},#{expired_time})")
    void maketrade(Trade trade);

  //  void updateTradeState(String trade_state);

}
