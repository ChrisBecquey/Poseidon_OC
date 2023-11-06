package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.interfaces.ITradeService;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeService implements ITradeService {
    private final TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public void createTrade(Trade trade) {
        tradeRepository.save(trade);
    }

    @Override
    public List<Trade> findAll() {
        return tradeRepository.findAll();
    }

    @Override
    public Optional<Trade> findById(Integer tradeId) {
        return tradeRepository.findById(tradeId);
    }

    @Override
    public void updateTrade(Trade trade) {
        tradeRepository.save(trade);
    }

    @Override
    public void deleteTrade(Trade trade) {
        tradeRepository.delete(trade);
    }
}
