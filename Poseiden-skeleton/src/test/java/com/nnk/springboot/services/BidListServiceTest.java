package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
class BidListServiceTest {

    @InjectMocks
    private BidListService bidListService;

    @Mock
    private BidListRepository bidListRepository;

    @Test
    void createBidList() {
        BidList bid = new BidList("Account Test", "Type Test", 10d);
        when(bidListRepository.save(any())).thenReturn(bid);
        bidListService.createBidList(bid);
        verify(bidListRepository, times(1)).save(bid);
    }

    @Test
    void findAll() {
        BidList bid = new BidList("Account Test", "Type Test", 10d);
        BidList bid2 = new BidList("Account Test2", "Type Test", 11d);
        when(bidListRepository.findAll()).thenReturn(List.of(bid, bid2));

        List<BidList> bidLists = bidListService.findAll();
        assertEquals(bidLists.size(), 2);
    }

    @Test
    void findById() {
        BidList bid = new BidList("Account Test", "Type Test", 10d);

        when(bidListRepository.findById(anyInt())).thenReturn(Optional.of(bid));

        assertEquals(bidListService.findById(1), Optional.of(bid));
    }

    @Test
    void updateBidList() {
    }
//
//    @Test
//    void deleteById() {
//        BidList bid = new BidList("Account Test", "Type Test", 10d);
//        when(bidListRepository.deleteById(any())).thenReturn();
//    }
}