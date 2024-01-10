package org.example;

import org.example.enums.VehicleType;

public class Bike extends Vehicle {
  Bike(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
    this.vehicleType = VehicleType.BIKE;
  }

}
