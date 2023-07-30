package exercise02.utils;

import exercise02.entities.RacingVehicles;

public class Calculation {
  private static void showCalculation(RacingVehicles vehicle, double distanceInKm, int[] times) {
    System.out.printf(
        "At a speed of %.0f km/h the %S would take %,.2fkm %dD %dH %dM %dS %dC\n",
        vehicle.getSpeed(), vehicle.getType(), distanceInKm, times[0], times[1], times[2], times[3], times[4]);
  }

  public static void calculationTime(RacingVehicles vehicles, double distance) {
    int[] times = new int[5]; // 5 posiciones para DIAS, HORAS, MINUTOS, SEGUNDOS Y CENTECIMAS
    double distanceInKm = distance / 1000;
    double totalHundredths = (distanceInKm / vehicles.getSpeed()) * 60 * 60 * 100;

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
    showCalculation(vehicles, distanceInKm, times);
  }
}
