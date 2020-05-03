package com.capg.fms.passenger.service;

import java.util.List;

import com.capg.fms.passenger.model.Passenger;

public interface IPassengerService {
 
    Passenger addPassenger(Passenger passenger);
	boolean deletePassenger(long passengerNumber);
	Passenger getPassenger(long passengerNumber);
	List<Passenger> getAllPasssengers();
	Passenger updatePassenger(Passenger passenger);

	boolean validatePassengerNumber(long passengerNumber);
	boolean validatePassengerUIN(long passengerUIN); 
	
 
}
