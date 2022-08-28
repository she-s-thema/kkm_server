package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Trade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TradeRepository {
    @Insert("INSERT INTO Trade VALUES(#{trade_id}, #{post_id},#{post_owner_id},#{trader_id}, #{trade_type}, #{trade_cost},#{trade_state},#{start_time},#{expired_time}, #{post_state})")
    void insertTrade(Trade trade);

    @Update("UPDATE Trade SET trade_state = #{trade_state}")
    void updateTradeState(Trade trade);
}
