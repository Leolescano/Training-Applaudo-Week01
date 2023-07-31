package exercise01.entities;

import java.util.Random;
import lombok.Getter;

public abstract class ArrayClass {
  @Getter protected int[] array;

  public ArrayClass() {
    Random random = new Random();
    // Genera un número aleatorio entre 1 y 20 para el tamaño del array
    int arraySize = random.nextInt(20) + 1;
    this.array = new int[arraySize];
    // Llena el array con numeros entre 1 y 50
    for (int i = 0; i < this.array.length; i++) {
      this.array[i] = random.nextInt(50) + 1;
    }
  }

  public void showArray() {
    System.out.print("[");
    for (int number : this.array) {
      System.out.print(" " + number + " ");
    }
    System.out.print("]\n");
  }

  abstract void setArray();
}
