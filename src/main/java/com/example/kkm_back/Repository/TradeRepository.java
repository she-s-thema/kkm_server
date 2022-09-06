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

    @Update("UPDATE Trade SET trade_state = #{trade_state}, trader_id = #{trader_id},start_time=#{start_time},expired_time=#{expired_time} WHERE trade_id = #{trade_id}")
    void tradeSet(@Param("trade_state")String trade_state,@Param("trader_id")String trader_id,@Param("start_time")String start_time,@Param("expired_time")String expired_time,@Param("trade_id")String trade_id);

  //  void updateTradeState(String trade_state);

}
