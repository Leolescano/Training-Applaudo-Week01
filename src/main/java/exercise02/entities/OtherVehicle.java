package exercise02.entities;

import java.util.Scanner;

public class OtherVehicle extends RacingVehicles {
  public OtherVehicle(double speed, String type) {
    super(speed);
    this.type = type;
  }

  public static int speedOtherVehicle() {
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    int speed = 0;
    do {
      try {
        System.out.print("Enter the speed of the other vehicle ");
        speed = sc.nextInt();
        flag = false;

      } catch (Exception e) {
        System.out.println("Invalid Speed value");
        sc.nextLine();
      }
    } while (flag);
    return speed;
  }

  public static String typeOtherVehicle() {
    Scanner sc = new Scanner(System.in);
    String type = "";
    System.out.print("Enter the type of the other vehicle ");
    type = sc.nextLine();
    return type;
  }
}
