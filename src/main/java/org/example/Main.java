package org.example;

import org.example.customExceptions.VehicleNotFoundException;
import org.example.enums.VehicleType;
import org.example.customExceptions.NoSpaceException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  private static ParkingLot parkingLot;
  private static Integer maxLevels;
  private static Integer maxBikeSpots;
  private static Integer maxCarSpots;
  private static Integer maxBusSpots;

  static {
    maxLevels = 3;
    maxBikeSpots = 5;
    maxCarSpots = 2;
    maxBusSpots = 1;
  }

  public static void main(String[] args) {

    parkingLot = new ParkingLot(maxLevels, maxBikeSpots, maxCarSpots, maxBusSpots);
    park(VehicleType.CAR, "2019");
    park(VehicleType.CAR, "2020");
    park(VehicleType.CAR, "2021");
    park(VehicleType.CAR, "2022");
    park(VehicleType.CAR, "2023");
    park(VehicleType.CAR, "2023");
    park(VehicleType.CAR, "2024");
    park(VehicleType.CAR, "2025");
    park(VehicleType.CAR, "2025");
    park(VehicleType.CAR, "2025");
    park(VehicleType.CAR, "2026");
    unPark("2019");
    park(VehicleType.CAR, "2027");
    parkingLot.printAvailableSlots();
  }

  public static void park(VehicleType type, String vehicleNumber) {
    try {
      switch (type) {
        case BIKE:
          parkingLot.parkVehicle(new Bike(vehicleNumber));
          break;
        case CAR:
          parkingLot.parkVehicle(new Car(vehicleNumber));
          break;
        case BUS:
          parkingLot.parkVehicle(new Bus(vehicleNumber));
          break;
        default:
          break;
      }
    } catch (NoSpaceException ex) {
      System.out.println(ex.getMessage());
    }
  }

  public static void unPark(String vehicleNumber) {
    try {
      parkingLot.unParkVehicle(vehicleNumber);
    } catch (VehicleNotFoundException ex) {
      System.out.println(ex.getMessage());
    }
  }
}