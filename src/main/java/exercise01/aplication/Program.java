package exercise01.aplication;

import exercise01.entities.Calculation;

public class Program {
  public static void main(String[] args) {

    Calculation calc = new Calculation();

    calc.showArray(); // Showing the array
    System.out.println(calc);

    calc.setArray(); // Restarting the array
    calc.showArray();
    System.out.println(calc);
  }
}
