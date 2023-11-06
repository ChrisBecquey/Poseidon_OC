package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
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
class CurvePointServiceTest {

    @InjectMocks
    private CurvePointService curvePointService;

    @Mock
    private CurvePointRepository curvePointRepository;

    @Test
    void createCurvePoint() {
        CurvePoint curvePoint = new CurvePoint(10, 10d, 30d);
        when(curvePointRepository.save(any())).thenReturn(curvePoint);
        curvePointService.createCurvePoint(curvePoint);
        verify(curvePointRepository, times(1)).save(curvePoint);
    }

    @Test
    void findAll() {
        CurvePoint curvePoint = new CurvePoint(10, 10d, 30d);
        CurvePoint curvePoint1 = new CurvePoint(20, 20d, 20d);

        when(curvePointRepository.findAll()).thenReturn(List.of(curvePoint, curvePoint1));
        List<CurvePoint> curvePoints = curvePointService.findAll();
        assertEquals(curvePoints.size(), 2);
    }

    @Test
    void findById() {
        CurvePoint curvePoint = new CurvePoint(10, 10d, 10d);

        when(curvePointRepository.findById(anyInt())).thenReturn(Optional.of(curvePoint));

        assertEquals(curvePointService.findById(1), Optional.of(curvePoint));
    }
}
