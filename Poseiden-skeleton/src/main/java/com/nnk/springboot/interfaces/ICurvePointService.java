package com.nnk.springboot.interfaces;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;
import java.util.Optional;

public interface ICurvePointService {
    void createCurvePoint(CurvePoint curvePoint);

    List<CurvePoint> findAll();

    Optional<CurvePoint> findById(Integer curvePointId);

    void updateCurvePoint(CurvePoint curvePoint);

    void deleteCurvePoint(CurvePoint curvePoint);
}
