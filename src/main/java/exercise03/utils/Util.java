package exercise03.utils;

import exercise03.exceptions.InvalidDatesException;
import exercise03.models.Country;
import exercise03.models.Element;
import exercise03.models.Product;
import exercise03.models.User;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Util {
  public static final Scanner SC = new Scanner(System.in);

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
    boolean valid = false;

    String nameProduct = null;
    while (!valid) {
      nameProduct = enterName("country");
      valid = validateName(nameProduct);
    }
    product.setName(nameProduct);

    product.setStock(validateStock());

    return product;
  }

  public static Element createCountry() {
    Country country = new Country();
    boolean valid = false;

    String nameCountry = null;
    while (!valid) {
      nameCountry = enterName("country");
      valid = validateName(nameCountry);
    }
    country.setName(nameCountry);

    country.setIsoCode(validateIso());

    return country;
  }

  public static Element createUser() {
    User user = new User();
    boolean valid = false;
    user.setName(validateUserName());

    String firstName = null;
    while (!valid) {
      System.out.print("Enter the first name: ");
      firstName = SC.nextLine();
      valid = validateName(firstName);
    }
    user.setFirstName(firstName);

    valid = false;
    String lastName = null;
    while (!valid) {
      System.out.print("Enter the last name: ");
      lastName = SC.nextLine();
      valid = validateName(lastName);
    }
    user.setLastName(lastName);

    return user;
  }

  public static String enterName(String typeElement) {
    System.out.printf("Enter the name of the %s: ", typeElement);
    return SC.nextLine();
  }

  public static boolean validateName(String name) {

    // Más de dos letras con espacios y sin caracteres especiales
    String pattern = "^(?=.*[a-zA-Z].*[a-zA-Z].*[a-zA-Z])[a-zA-Z ]+$";
    try {
      boolean valid = Pattern.matches(pattern, name);
      if (valid) {
        return true;
      } else {
        throw new InvalidDatesException("You have to enter a valid name.");
      }
    } catch (InvalidDatesException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  public static String validateIso() {
    String pattern = "^[A-Z]{2}$";
    do {
      try {
        System.out.print("Enter the ISO country code ('US'): ");
        String isoCode = SC.next();
        boolean valid = Pattern.matches(pattern, isoCode);
        if (valid) {
          return isoCode;

        } else {
          throw new InvalidDatesException("This is NOT a valid ISO 3166-1 alpha-2 country code.");
        }
      } catch (InvalidDatesException e) {
        System.out.println(e.getMessage());
      }
    } while (true);
  }

  public static int validateStock() {
    while (true) {
      try {
        System.out.print("Enter the quantity in Stock: ");
        int stock = SC.nextInt();
        if (stock < 0) {
          throw new InvalidDatesException("Stock cannot be a negative number.");
        }
        SC.nextLine();
        return stock;
      } catch (InputMismatchException e) {
        System.out.println("You must enter an integer.");
      } catch (InvalidDatesException e) {
        System.out.println(e.getMessage());
      }
      SC.nextLine();
    }
  }

  public static String validateUserName() {
    // más de 3 letras y deve comenzar con el caracter especial #
    String pattern = "^#[a-zA-Z0-9]{3,}$";
    do {
      try {
        System.out.print(
            "Enter the username, it is mandatory that it starts with '#'"
                + "and have a minimum of 3 letters or numbers: ");
        String userName = SC.nextLine();
        boolean valid = Pattern.matches(pattern, userName);
        if (valid) {
          return userName;
        } else {
          throw new InvalidDatesException("The entered is not valid username.");
        }
      } catch (InvalidDatesException e) {
        System.out.println(e.getMessage());
      }
    } while (true);
  }
}
