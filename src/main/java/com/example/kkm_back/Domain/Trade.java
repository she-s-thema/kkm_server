package com.example.kkm_back.Domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Getter
@Setter
public class Trade {
    private long trade_id;
    private long post_id;
    private long post_owner_id;
    private long trader_id;
    private long trade_cost;
    private long trade_state;
    private java.sql.Timestamp start_time;
    private java.sql.Timestamp expired_time;

    public Trade(long trade_id, long post_id, long post_owner_id, long trader_id, long trade_cost, long trade_state,java.sql.Timestamp start_time, java.sql.Timestamp expired_time){
        this.trade_id=trade_id;
        this.post_id=post_id;
        this.post_owner_id=post_owner_id;
        this.trader_id=trader_id;
        this.trade_cost=trade_cost;
        this.trade_state=trade_state;
        this.start_time=start_time;
        this.expired_time=expired_time;


    }

}
