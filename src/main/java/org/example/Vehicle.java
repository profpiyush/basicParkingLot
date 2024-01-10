package org.example;

import org.example.enums.VehicleType;


abstract class Vehicle {
  public VehicleType vehicleType;
  public String vehicleNumber;


  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }
}
