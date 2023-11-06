package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class RatingServiceTest {
    @InjectMocks
    private RatingService ratingService;

    @Mock
    private RatingRepository ratingRepository;

    @Test
    void createRating() {
        Rating rating = new Rating("Moodys Rating", "Sand PRating", "Fitch Rating", 10);
        when(ratingRepository.save(any())).thenReturn(rating);
        ratingService.createRating(rating);
        verify(ratingRepository, times(1)).save(rating);
    }

    @Test
    void findAll() {
        Rating rating = new Rating("Moodys Rating", "Sand PRating", "Fitch Rating", 10);
        Rating rating2 = new Rating("Moodys Rating2", "Sand PRating2", "Fitch Rating2", 8);
        when(ratingRepository.findAll()).thenReturn(List.of(rating2, rating));

        List<Rating> ratingList = ratingService.findAll();
        assertEquals(ratingList.size(), 2);
    }

    @Test
    void findById() {
        Rating rating = new Rating("moodys Rating", "Sand PRating", "Fitch Rating", 12);

        when(ratingRepository.findById(anyInt())).thenReturn(Optional.of(rating));

        assertEquals(ratingService.findById(1), Optional.of(rating));
    }
}
