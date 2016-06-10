package com.thejavageek.jpa.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Bike")
public class Bike extends PassengerVehicle {

	private int saddleHeight;

	public int getSaddleHeight() {
		return saddleHeight;
	}

	public void setSaddleHeight(int saddleHeight) {
		this.saddleHeight = saddleHeight;
	}

}