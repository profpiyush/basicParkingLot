package org.example.customExceptions;

public class VehicleNotFoundException extends Exception{
  public VehicleNotFoundException(String message) {
    super(message);
  }
}
