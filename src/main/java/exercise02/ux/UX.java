package exercise02.ux;

import exercise02.interfaces.UXInterface;
import exercise02.models.OtherVehicle;
import exercise02.models.RacingVehicles;
import exercise02.utils.CalculationTime;
import exercise02.utils.Utils;

public class UX implements UXInterface {

  @Override
  public void showMenu() {
    // Scanner sc = new Scanner(System.in);
    RacingVehicles vehicle = null;

    String opVehicle;
    String type = "Other vehicle";
    String question = "";

    double distanceInMeters;
    int speed = 0;

    while (true) {
      System.out.printf(
          """

              Choose the vehicle with which you will travel
              1) Bike - Speed 6km/h
              2) Car - Speed 60km/h
              3) Motorcycle - Speed 80km/h
              4) %s - Speed %dKm/h    %s
              5) Exit%n""",
          type, speed, question);
      System.out.print("OP: ");
      opVehicle = Utils.SC.nextLine();
      switch (opVehicle) {
        case "1", "2", "3" -> {
          vehicle = Utils.createVehicle(opVehicle);
          distanceInMeters = Utils.enterDistanceInMeters();
          CalculationTime.calculationTime(vehicle, distanceInMeters);
        }
        case "4" -> {
          type = OtherVehicle.typeOtherVehicle();
          speed = OtherVehicle.speedOtherVehicle(type);
          question = "Another vehicle?";
          vehicle = new OtherVehicle(speed, type);
          distanceInMeters = Utils.enterDistanceInMeters();
          CalculationTime.calculationTime(vehicle, distanceInMeters);
        }
        case "5" -> {
          System.out.println("Thanks for using the system.");
          return;
        }
        default -> System.out.println("Enter a valid option.");
      }
      Utils.SC.nextLine();
    }
  }
}
