package org.example;

import org.example.enums.VehicleType;

public class Bus extends Vehicle {
  Bus(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
    this.vehicleType = VehicleType.BUS;
  }

}
