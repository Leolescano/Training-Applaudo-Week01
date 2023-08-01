package exercise02.models;

import exercise02.exceptions.SpeedException;
import exercise03.exceptions.InvalidDatesException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OtherVehicle extends RacingVehicles {
  public OtherVehicle(double speed, String type) {
    super(speed);
    this.type = type;
  }

  public static String typeOtherVehicle() {
    Scanner sc = new Scanner(System.in);
    String type = "";
    System.out.print("Enter the type of the other vehicle ");
    type = sc.nextLine();
    return type;
  }

  public static int speedOtherVehicle(String type) {
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    int speed = 0;
    do {
      try {
        System.out.printf("Enter the speed of %s: ", type);
        speed = sc.nextInt();
        if (speed > 0) {
          flag = false;
        } else {
          throw new SpeedException("Velocity must be greater than zero");
        }
      } catch (InputMismatchException e) {
          System.out.println("Invalid speed value");
          sc.nextLine();
      } catch (SpeedException e) {
        System.out.println(e.getMessage());
      }
    } while (flag);
    return speed;
  }
}
