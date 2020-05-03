package com.capg.fms.passenger.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.service.IPassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
@Autowired(required=false)
IPassengerService passengerService;

@PostMapping("/add")
public ResponseEntity<Passenger> addPassenger(@Valid @RequestBody Passenger passenger){
	if(passengerService.addPassenger(passenger)==null)
	{return new ResponseEntity<Passenger>(HttpStatus.BAD_REQUEST);  } 
	if(passengerService.validatePassengerNumber(passenger.getPassengerNumber())&& passengerService.validatePassengerUIN(passenger.getPassengerUIN()))  
	{ return new ResponseEntity<Passenger>(passengerService.addPassenger(passenger),HttpStatus.OK);}
	return new ResponseEntity<Passenger>(HttpStatus.BAD_REQUEST);
}

@DeleteMapping("/delete/number/{passengerNumber}")
public boolean deletePassenger(@PathVariable("passengerNumber") long passengerNumber)
{
	    return passengerService.deletePassenger(passengerNumber);
}


@GetMapping("/number/{passengerNumber}")
public ResponseEntity<Passenger> getPassenger(@PathVariable("passengerNumber") long passengerNumber)
{
	
	return new ResponseEntity<Passenger>(passengerService.getPassenger(passengerNumber),HttpStatus.OK); 
		
}

@GetMapping("/all")
public ResponseEntity<List<Passenger>> getAllPassengers()
{
return new ResponseEntity<List<Passenger>>(passengerService.getAllPasssengers(),HttpStatus.OK);
}

@PutMapping("/update")
public ResponseEntity<Passenger> updatePassenger(@Valid @RequestBody Passenger passenger)
{if(passengerService.validatePassengerNumber(passenger.getPassengerNumber())&& passengerService.validatePassengerUIN(passenger.getPassengerUIN())) 
	{return new ResponseEntity<Passenger>(passengerService.updatePassenger(passenger),HttpStatus.OK);}
   return new ResponseEntity<Passenger>(HttpStatus.BAD_REQUEST);

}


}

