package exercise02.models;

import exercise02.exceptions.SpeedException;
import exercise02.utils.Utils;
import exercise03.exceptions.InvalidDatesException;
import java.util.InputMismatchException;

public class OtherVehicle extends RacingVehicles {
  public OtherVehicle(double speed, String type) {
    super(speed);
    this.type = type;
  }

  public static String typeOtherVehicle() {
    String type;
    do {
      try {
        System.out.print("Enter the type of the other vehicle ");
        type = Utils.SC.nextLine();
        if (type.length() >= 2) {
          break;
        } else {
          throw new InvalidDatesException(
              "The type of vehicle must contain more than one character.");
        }
      } catch (InvalidDatesException e) {
        System.out.println(e.getMessage());
      }
    } while (true);
    return type;
  }

  public static int speedOtherVehicle(String type) {
    boolean flag = true;
    int speed = 0;
    do {
      try {
        System.out.printf("Enter the speed of %s: ", type);
        speed = Utils.SC.nextInt();
        if (speed > 0) {
          flag = false;
        } else {
          throw new SpeedException("Velocity must be greater than zero");
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid speed value");
      } catch (SpeedException e) {
        System.out.println(e.getMessage());
      }
      Utils.SC.nextLine();
    } while (flag);
    return speed;
  }
}
