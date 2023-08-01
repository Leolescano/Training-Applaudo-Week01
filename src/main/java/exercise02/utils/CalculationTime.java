package exercise02.utils;

import exercise02.models.RacingVehicles;

public class CalculationTime {

  private static void showCalculation(RacingVehicles vehicle, double distanceInKm, int[] times) {
    String day = times[0] > 0 ? String.format("%s Days", times[0]) : "";
    System.out.printf(
        """
              Type: %s
              Speed: %.0f km/h
              Distance: %,.3fkm
              Time it takes: %s %d Horas %d Minutos %d.%d Segundos
              """,
        vehicle.getType(),
        vehicle.getSpeed(),
        distanceInKm,
        day,
        times[1],
        times[2],
        times[3],
        times[4]);
    System.out.print("Press any key to continue.");
    Utils.SC.nextLine();
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
