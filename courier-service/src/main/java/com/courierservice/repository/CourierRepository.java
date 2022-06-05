package com.courierservice.repository;

import com.courierservice.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Integer> {

    Optional<Courier> findByCode (String code);
}
