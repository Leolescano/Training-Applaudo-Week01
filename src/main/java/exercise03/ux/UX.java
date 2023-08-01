package exercise03.ux;

import exercise02.utils.Utils;
import exercise03.interfaces.UXInterface;
import exercise03.models.*;
import exercise03.utils.Util;

public class UX implements UXInterface {

  public void showMenu() {
    String op;
    boolean flag = true;
    Repository<Element> productRepository = new Repository<>();
    Repository<Element> countryRepository = new Repository<>();
    Repository<Element> userRepository = new Repository<>();
    while (flag) {
      System.out.println(
          """

    Choose repository to work:
        P) 'P'roducts repository
        C) 'C'ountries repository
        U) 'U'sers repository
        F) 'F'inish jobs""");
      System.out.print("OP: ");
      op = Utils.SC.nextLine().toUpperCase();
      switch (op) {
        case "P" -> showMenuRepository(productRepository, "Products");
        case "C" -> showMenuRepository(countryRepository, "Countries");
        case "U" -> showMenuRepository(userRepository, "Users");
        case "F" -> {
          System.out.print("Are you sure you want to log out? Y/N: ");
          String exit = Utils.SC.nextLine().toUpperCase();
          if (exit.equals("Y")) {
            flag = false;
          }
        }
      }
    }
    System.out.println("You logged out of the system");
  }

  public void showMenuRepository(Repository<Element> repository, String typeRepository) {
    String op;
    boolean flag = true;
    Element element = null;
    switch (typeRepository) {
      case "Products" -> element = new Product();
      case "Countries" -> element = new Country();
      case "Users" -> element = new User();
    }
    while (flag) {
      System.out.printf(
          """

				What would you like to do with the %s repository?
					1) Save to repository
					2) Count to repository
					3) Find to repository
					4) Show Repository
					5) Delete element
					6) Back to previous menu%n""",
          typeRepository);
      System.out.print("OP: ");
      op = Utils.SC.nextLine();
      switch (op) {
        case "1" -> {
          assert element != null;
          repository.save(Util.enterDates(element));
        }
        case "2" -> {
          repository.count(typeRepository);
        }
        case "3" -> {
          Element elem = repository.find(typeRepository);
          if (elem != null) {
            System.out.println(elem);
          }
        }
        case "4" -> {
          repository.showRepository();
        }
        case "5" -> {
          repository.deleteElement();
        }
        case "6" -> flag = false;
      }
    }
  }
}
