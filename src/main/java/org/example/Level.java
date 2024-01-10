package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.example.customExceptions.VehicleAlreadyParkedException;
import org.example.customExceptions.VehicleNotFoundException;
import org.example.enums.VehicleType;

public class Level {
  private Integer levelNumber;
  HashMap<String, VehicleType> vehicleNumberToVehicleTypeMap = new HashMap<>();
  Map<VehicleType, Integer> vehicleTypeToAvailableSpotsMap = new HashMap<>();

  Level(Integer maxBikeSpots, Integer maxCarSpots, Integer maxBusSpots, Integer levelNumber) {
    this.vehicleTypeToAvailableSpotsMap.put(VehicleType.BIKE, maxBikeSpots);
    this.vehicleTypeToAvailableSpotsMap.put(VehicleType.CAR, maxCarSpots);
    this.vehicleTypeToAvailableSpotsMap.put(VehicleType.BUS, maxBusSpots);

    this.levelNumber = levelNumber;
  }

  public Boolean park(Vehicle vehicle) throws VehicleAlreadyParkedException {
    if (!vehicleNumberToVehicleTypeMap.containsKey(vehicle.getVehicleNumber())) {
      if (this.canPark(vehicle.getVehicleType())) {
        vehicleNumberToVehicleTypeMap.put(vehicle.getVehicleNumber(), vehicle.getVehicleType());
        vehicleTypeToAvailableSpotsMap.compute(vehicle.getVehicleType(),
            (type, count) -> (count == null) ? null : count - 1);
        System.out.println(vehicle.getVehicleType() + " with number " + vehicle.getVehicleNumber()
            + " is successfully parked at level: " + levelNumber);
        return Boolean.TRUE;
      }
    } else {
      throw new VehicleAlreadyParkedException(
          vehicle.getVehicleType() + " with number " + vehicle.getVehicleNumber()
              + " is Already Parked at level: " + levelNumber);
    }
    return Boolean.FALSE;
  }

  public VehicleType unPark(String vehicleNumber) throws VehicleNotFoundException {
    VehicleType typeOfVehicleRemoved = vehicleNumberToVehicleTypeMap.remove(vehicleNumber);
    vehicleTypeToAvailableSpotsMap.compute(typeOfVehicleRemoved,
        (type, count) -> (count == null) ? null : count + 1);
    if (Objects.nonNull(typeOfVehicleRemoved)) {
      System.out.println(typeOfVehicleRemoved + " with number " + vehicleNumber
          + " is successfully UN-PARKED at level: " + levelNumber);
    }
    return typeOfVehicleRemoved;
  }

  private Boolean canPark(VehicleType type) {
    return vehicleTypeToAvailableSpotsMap.get(type) > 0;
  }

  public void printAvailableSlots(){
    System.out.print("Level: " + levelNumber + " -  ");
    vehicleTypeToAvailableSpotsMap.forEach((vehicleType, integer) -> System.out.print(vehicleType + " : " + integer + " "));
    System.out.println();
  }
}
