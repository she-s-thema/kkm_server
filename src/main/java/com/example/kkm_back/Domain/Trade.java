package com.example.kkm_back.Domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Getter
@Setter
public class Trade {
    private int trade_id;
    private int post_id;
    private int post_owner_id;
    private int trader_id;
    private int trade_type;
    private int trade_cost;
    private int trade_state;
    private Date start_time;
    private Date expired_time;
    private int post_state;

    public Trade(int trade_id, int post_id, int post_owner_id, int trader_id, int trade_type, int trade_cost, int trade_state,Date start_time, Date expired_time,int post_state){
        this.trade_id=trade_id;
        this.post_id=post_id;
        this.post_owner_id=post_owner_id;
        this.trader_id=trader_id;
        this.trade_type=trade_type;
        this.trade_cost=trade_cost;
        this.trade_state=trade_state;
        this.start_time=start_time;
        this.expired_time=expired_time;
        this.post_state=post_state;


    }

}
