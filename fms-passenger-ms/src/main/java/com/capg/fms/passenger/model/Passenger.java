package com.capg.fms.passenger.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;



@Entity
@Table(name="passenger")
public class Passenger {
   @Id
	private long passengerNumber;
   
   @NotBlank(message= "Name should not be empty")
   @Size(min=3, max=40)
	private String passengerName;
   
   @NotNull 
//   @NumberFormat(style= Style.NUMBER)@Min(10)
   @Range(min=10, max=80)
	private int passengerAge;
	private long passengerUIN;
	private double luggage;
	
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(long passengerNumber,
			@NotBlank(message = "Name should not be empty") @Size(min = 3, max = 40) String passengerName,
			@NotNull @Range(min = 10, max = 80) int passengerAge, long passengerUIN, double luggage) {
		super();
		this.passengerNumber = passengerNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.luggage = luggage;
	}
	
	public long getPassengerNumber() {
		return passengerNumber;
	}
	public void setPassengerNumber(long passengerNumber) {
		this.passengerNumber = passengerNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public long getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(long passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public double getLuggage() {
		return luggage;
	}
	public void setLuggage(double luggage) {
		this.luggage = luggage;
	}

	@Override
	public String toString() {
		return "Passenger [passengerNumber=" + passengerNumber + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerUIN=" + passengerUIN + ", luggage=" + luggage + "]";
	}
	
	
}
