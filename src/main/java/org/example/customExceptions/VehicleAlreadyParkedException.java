package org.example.customExceptions;

public class VehicleAlreadyParkedException extends Exception{
  public VehicleAlreadyParkedException(String message) {
    super(message);
  }
}
