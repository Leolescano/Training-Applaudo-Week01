package exercise01.models;

import exercise01.interfaces.Average;
import exercise01.interfaces.Max;
import exercise01.interfaces.Min;
import lombok.Getter;

public class Calculation extends ArrayClass implements Max, Min, Average {
  @Getter private int max;
  @Getter private int min;
  @Getter private double average;

  public Calculation() {
    super();
    this.setMax();
    this.setMin();
    this.setAverage();
  }

  @Override
  public void setMax() {
    int numberMax = this.array[0];
    for (int number : this.array) {
      numberMax = Math.max(numberMax, number);
    }
    this.max = numberMax;
  }

  @Override
  public void setMin() {
    int numberMin = this.array[0];
    for (int number : this.array) {
      numberMin = Math.min(numberMin, number);
    }
    this.min = numberMin;
  }

  @Override
  public void setAverage() {
    double average = 0;
    for (int number : this.array) {
      average += number;
    }
    this.average = average / this.array.length;
  }

  @Override
  public void setArray() {
    Calculation newCalc = new Calculation();
    this.array = newCalc.getArray();
    newCalc.setMax();
    this.max = newCalc.getMax();
    newCalc.setMin();
    this.min = newCalc.getMin();
    newCalc.setAverage();
    this.average = newCalc.getAverage();
  }

  @Override
  public String toString() {
    this.showArray();
    return String.format(
        """
				The maximum number in the array is: %d
				The minimum number in the array is: %d
				The average of the array is: %.2f
				"""
            .formatted(this.max, this.min, this.average));
  }
}
