package exercise02.entities;

public class TripData {
  //
  public static RacingVehicles createVehicle(
      double opVehicle, double distanceInMeters, String type, int speed) {
    switch ((int) opVehicle) {
      case 1 -> {
        return new Bike();
      }
      case 2 -> {
        return new Car();
      }
      case 3 -> {
        return new Motorcycle();
      }
      case 4 -> {
        return new OtherVehicle(speed, type);
      }
    }
    return null;
  }

  public static void trip(double opVehicle, double distanceInMeters, String type, int speed) {
    RacingVehicles vehicle = createVehicle(opVehicle, distanceInMeters, type, speed);
    int[] times = Calculation.calculationTime(vehicle, distanceInMeters);
    Calculation.showCalculation(vehicle, distanceInMeters, times);
  }
}
