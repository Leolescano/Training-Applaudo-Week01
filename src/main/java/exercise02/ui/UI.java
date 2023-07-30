package exercise02.ui;

import exercise02.entities.OtherVehicle;
import exercise02.utils.Utils;
import exercise02.interfaces.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI implements Menu {
  @Override
  public void showMenu() {
    Scanner sc = new Scanner(System.in);
    String opVehicle;
    double distanceInMeters = 0;
    int speed = 0;
    String type = "";
    boolean flag = true;
    System.out.println(
        """
				Choose the vehicle with which you will travel
				1) Bike - Speed 6km/h
				2) Car - Speed 60km/h
				3) Motorcycle - Speed 80km/h
				4) Other vehicle - Speed ?
				5) Cancel trip""");
    System.out.print("OP:");
    do {
      opVehicle = sc.next();
    } while (!opVehicle.equals("1")
        && !opVehicle.equals("2")
        && !opVehicle.equals("3")
        && !opVehicle.equals("4")
        && !opVehicle.equals("5"));
    if (opVehicle.equals("5")) {
      return;
    }
    if (opVehicle.equals("4")) {
      type = OtherVehicle.typeOtherVehicle();
      speed = OtherVehicle.speedOtherVehicle();
    }
    while (flag) {
      try {
        System.out.print("Enter the number of meters to travel: ");
        distanceInMeters = sc.nextDouble();
        flag = false;
      } catch (InputMismatchException e) {
        System.out.println("You must enter a number for the program to continue");
        sc.nextLine();
      }
    }
    Utils.trip(opVehicle, distanceInMeters, type, speed);
  }
}
