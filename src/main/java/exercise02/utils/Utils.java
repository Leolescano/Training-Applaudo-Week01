package exercise02.utils;

import exercise02.exceptions.DistanceInMetersException;
import exercise02.models.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class Utils {
  public static RacingVehicles createVehicle(String opVehicle) {
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
    }
    return null;
  }

  public static double enterDistanceInMeters() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      try {
        System.out.print("\nEnter the number of meters to travel: ");
        double distanceInMeters = sc.nextDouble();
        System.out.println();
        if (distanceInMeters > 0) {
          return distanceInMeters;
        } else {
          throw new DistanceInMetersException("The distance must be greater than zero.");
        }
      } catch (InputMismatchException e) {
        System.out.println("You must enter a number for the program to continue");
        sc.nextLine();
      } catch (DistanceInMetersException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
