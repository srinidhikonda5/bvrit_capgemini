package com.capg.fms.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.fms.passenger.model.Passenger;

public interface IPassengerRepo extends JpaRepository<Passenger,Long>{

}
