package org.example;

import org.example.customExceptions.NoSpaceException;
import org.example.customExceptions.VehicleAlreadyParkedException;
import org.example.customExceptions.VehicleNotFoundException;
import org.example.enums.VehicleType;

import java.util.ArrayList;

public class ParkingLot {

  ParkingLot(Integer maxLevels, Integer maxBikeSpots, Integer maxCarSpots, Integer maxBusSpots) {
    for (int i = 1; i <= maxLevels; i++) {
      levels.add(new Level(maxBikeSpots, maxCarSpots, maxBusSpots, i));
    }
  }

  private ArrayList<Level> levels = new ArrayList<>();

  public void parkVehicle(Vehicle vehicle) throws NoSpaceException {
    Boolean status = Boolean.FALSE;
    try {
      for (Level level : levels) {
        status = level.park(vehicle);
        if (status) {
          break;
        }
      }
      if (!status) {
        throw new NoSpaceException(
            "All " + vehicle.getVehicleType() + " slots are full, Hence can't park "
                + vehicle.getVehicleNumber());
      }
    } catch (VehicleAlreadyParkedException e) {
      System.out.println(e.getMessage());
    }
  }

  public void unParkVehicle(String vehicleNumber) throws VehicleNotFoundException {
    VehicleType status = null;
    try {
      for (Level level : levels) {
        status = level.unPark(vehicleNumber);
        if (null != status) {
          break;
        }
      }
      if (null == status) {
        throw new VehicleNotFoundException(
            "Vehicle with number = " + vehicleNumber + " is not found in the parkingLot");
      }
    } catch (VehicleNotFoundException ex) {
      System.out.println(ex.getMessage());
    }

  }

    public void printAvailableSlots() {
      System.out.println("Available spots: ");
      for (Level level : levels) {
        level.printAvailableSlots();
      }
    }
}
