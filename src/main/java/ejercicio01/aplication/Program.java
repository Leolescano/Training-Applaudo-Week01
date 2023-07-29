package ejercicio01.aplication;

import ejercicio01.entities.Calculation;

public class Program {
  public static void main(String[] args) {

    Calculation calc = new Calculation();

    calc.showArray();
    System.out.println(calc);

    calc.setArray();
    calc.showArray();
    System.out.println(calc);
  }
}
