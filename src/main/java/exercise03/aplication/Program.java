package exercise03.aplication;

import exercise02.utils.Utils;
import exercise03.ux.UX;

public class Program {
  public static void main(String[] args) {
    UX ux = new UX();
    ux.showMenu();
    Utils.SC.close();
  }
}
