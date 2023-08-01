package exercise03.models;

import exercise02.utils.Utils;
import exercise03.exceptions.InvalidDatesException;
import exercise03.interfaces.Count;
import exercise03.interfaces.Find;
import exercise03.interfaces.Save;
import exercise03.interfaces.ShowRepository;
import java.util.*;
import lombok.Getter;

public class Repository<T> implements Save<T>, Count, Find<T>, ShowRepository {

  @Getter private List<T> repository;

  public Repository() {
    this.repository = new ArrayList<>();
  }

  @Override
  public void save(T element) {
    this.repository.add(element);
    System.out.println("The element was saved successfully");
  }

  @Override
  public void count(String typeRepository) {
    if (this.repository.size() > 0) {
      System.out.printf("The repository contains %d %s\n", this.repository.size(), typeRepository);
    } else {
      System.out.println("The repository is empty");
    }
  }

  @Override
  public T find(String typeRepository) {
    int index;
    if (this.repository.size() == 0) {
      System.out.println("The repository is empty");
      return null;
    }
    while (true) {
      try {
        System.out.printf("Enter the position of the %s within the repository: ", typeRepository);
        index = Utils.SC.nextInt() - 1;
        Utils.SC.nextLine();
        if (index < this.repository.size() && index >= 0) {
          return this.repository.get(index);
        } else {
          throw new InvalidDatesException("That position does not exist in the repository");
        }
      } catch (InputMismatchException e) {
        System.out.println("You must enter an integer.");
        Utils.SC.nextLine();
      } catch (InvalidDatesException e) {
        System.out.println(e.getMessage());
        return null;
      }
    }
  }

  @Override
  public void showRepository() {
    if (this.repository.size() > 0) {
      int cont = 1;
      System.out.println();
      for (T element : this.repository) {
        System.out.print(cont + " -> ");
        System.out.print(element);
        cont++;
      }
    } else {
      System.out.println("The repository is empty");
    }
  }
}
