package exercise03.utils;

import exercise03.exceptions.InvalidDatesException;
import exercise03.models.Country;
import exercise03.models.Element;
import exercise03.models.Product;
import exercise03.models.User;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
  static final Scanner SC = new Scanner(System.in);

  public static Element enterDates(Element element) {
    if (element instanceof Product) {
      return createProduct();
    }
    if (element instanceof Country) {
      return createCountry();
    }
    if (element instanceof User) {
      return createUser();
    }
    return null;
  }

  public static Element createProduct() {
    Product product = new Product();
    product.setName(enterName("product"));
    while (true) {
      try {
        System.out.print("Enter the quantity in Stock: ");
        int stock = SC.nextInt();
        if (stock < 0) {
          throw new InvalidDatesException("Stock cannot be a negative number.");
        }
        product.setStock(stock);
        SC.nextLine();
        break;
      } catch (InputMismatchException e) {
        System.out.println("You must enter an integer.");
        SC.nextLine();
      } catch (InvalidDatesException e) {
        System.out.println(e.getMessage());
        SC.nextLine();
      }
    }
    return product;
  }

  public static Element createCountry() {
    Country country = new Country();
    country.setName(enterName("country"));
    System.out.print("Enter the ISO country code: ");
    String isoCode = SC.next();
    country.setIsoCode(isoCode);
    SC.nextLine();
    return country;
  }

  public static Element createUser() {
    User user = new User();
    System.out.print("Enter the name user: ");
    String userName = SC.nextLine();
    user.setName(userName);
    System.out.print("Enter the first name: ");
    String firstName = SC.nextLine();
    user.setFirstName(firstName);
    System.out.print("Enter the last name: ");
    String lastName = SC.nextLine();
    user.setLastName(lastName);
    return user;
  }

  public static String enterName(String typeElement) {
    System.out.printf("Enter the name of the %s: ", typeElement);
    return SC.nextLine();
  }
}
