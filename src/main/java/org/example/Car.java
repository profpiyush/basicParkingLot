package org.example;

import org.example.enums.VehicleType;

public class Car extends Vehicle {
  Car(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
    this.vehicleType = VehicleType.CAR;
  }
}
