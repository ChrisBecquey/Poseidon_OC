package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class TradeServiceTest {
    @InjectMocks
    private TradeService tradeService;

    @Mock
    private TradeRepository tradeRepository;

    @Test
    void createTrade() {
        Trade trade = new Trade("Trade Account", "Type");
        when(tradeRepository.save(any())).thenReturn(trade);
        tradeService.createTrade(trade);
        verify(tradeRepository, times(1)).save(trade);
    }

    @Test
    void findAll() {
        Trade trade = new Trade("Trade Account", "Type");
        Trade trade1 = new Trade("Trade Account1", "Type1");
        when(tradeRepository.findAll()).thenReturn(List.of(trade1, trade));

        List<Trade> trades = tradeService.findAll();
        assertEquals(trades.size(), 2);
    }

    @Test
    void findById() {
        Trade trade = new Trade("Trade Account", "Type");
        when(tradeRepository.findById(anyInt())).thenReturn(Optional.of(trade));
        assertEquals(tradeService.findById(1), Optional.of(trade));
    }
}