package exercise02.utils;

import exercise02.models.RacingVehicles;

public class CalculationTime {

  private static void showCalculation(RacingVehicles vehicle, double distanceInKm, int[] times) {
    if (times[0] == 0) {
      System.out.printf(
          """
              \nType: %s
              Speed: %.0f km/h
              Distance: %,.2fkm
              Time it takes: %d:%d:%d.%d
              """,
          vehicle.getType(),
          vehicle.getSpeed(),
          distanceInKm,
          times[1],
          times[2],
          times[3],
          times[4]);
    } else {
      System.out.printf(
          """
              \nType: %s
              Speed: %.0f km/h
              Distance: %,.2fkm
              Time it takes: %d Days %d:%d:%d.%d
             """,
          vehicle.getType(),
          vehicle.getSpeed(),
          distanceInKm,
          times[0],
          times[1],
          times[2],
          times[3],
          times[4]);
    }
  }

  public static void calculationTime(RacingVehicles vehicles, double distance) {
    int[] times = new int[5]; // 5 posiciones para DIAS, HORAS, MINUTOS, SEGUNDOS Y MILÉSIMAS
    double distanceInKm = distance / 1000;
    long totalMilliseconds = (long) ((distanceInKm / vehicles.getSpeed()) * 60 * 60 * 1000);

    int seconds = (int) (totalMilliseconds / 1000);
    int milliseconds = (int) (totalMilliseconds % 1000);
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
    times[4] = milliseconds;
    showCalculation(vehicles, distanceInKm, times);
  }
}
