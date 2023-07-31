package exercise02.utils;

import exercise02.models.*;

public final class Utils {
  public static RacingVehicles createVehicle(String opVehicle, String type, int speed) {
    switch (opVehicle) {
      case "1" -> {
        return new Bike();
      }
      case "2" -> {
        return new Car();
      }
      case "3" -> {
        return new Motorcycle();
      }
      case "4" -> {
        return new OtherVehicle(speed, type);
      }
    }
    return null;
  }

  public static void trip(String opVehicle, double distanceInMeters, String type, int speed) {
    RacingVehicles vehicle = createVehicle(opVehicle, type, speed);
    Calculation.calculationTime(vehicle, distanceInMeters);
  }
}
