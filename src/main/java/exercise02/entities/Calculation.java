package exercise02.entities;

public class Calculation {
  public static void showCalculation(RacingVehicles vehicle, double distance, int[] times) {
    System.out.printf(
        "The %s took time to go %,.2fkm %dD %dH %dM %dS %dC\n",
        vehicle.getType(), (distance / 1000), times[0], times[1], times[2], times[3], times[4]);
  }

  public static int[] calculationTime(RacingVehicles racingVehicles, double distance) {
    int[] times = new int[5];
    double distanceInKm = distance / 1000;
    double totalHundredths = (distanceInKm / racingVehicles.getSpeed()) * 60 * 60 * 100;

    int seconds = (int) totalHundredths / 100;
    int hundredths = (int) totalHundredths % 100;
    int minutes = seconds / 60;
    seconds = seconds % 60;
    int hours = minutes / 60;
    minutes = minutes % 60;
    int days = hours / 24;
    hours = hours % 24;

    times[0] = days;
    times[1] = hours;
    times[2] = minutes;
    times[3] = seconds;
    times[4] = hundredths;

    return times;
  }
}
