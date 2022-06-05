package com.courierservice.service;

import com.courierservice.model.Courier;

import java.util.List;

public interface CourierService {

    List<Courier> findAll();
    Courier findByCode(String code);
    Courier save(Courier courier);
    void delete(Integer id);
}
