package com.example.kkm_back.DAO;

import com.example.kkm_back.Domain.Trade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeDAO {
    public List<Trade> tradeList();
    public void tradeInsert(Trade trade);
}
