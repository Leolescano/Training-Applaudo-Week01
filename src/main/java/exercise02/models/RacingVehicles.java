package exercise02.models;

import lombok.Getter;
import lombok.Setter;

public abstract class RacingVehicles {
  @Getter protected double speed;

  @Getter protected String type;

  public RacingVehicles(double speed) {
    this.speed = speed;
  }
}
