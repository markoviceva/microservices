package com.courierservice.service;

import com.courierservice.model.Courier;
import com.courierservice.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService{

    private final CourierRepository courierRepository;

    @Override
    public List<Courier> findAll() {
        return courierRepository.findAll();
    }

    @Override
    public Courier findByCode(String code) {
        Optional<Courier> courier = courierRepository.findByCode(code);
        if(!courier.isPresent()) {
            throw new RuntimeException("No courier with code " + code);
        }
        return courier.get();
    }

    @Override
    public Courier save(Courier courier) {
        return courierRepository.save(courier);
    }

    @Override
    public void delete(Integer id) {
        courierRepository.deleteById(id);
    }
}
