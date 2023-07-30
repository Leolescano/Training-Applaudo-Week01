package exercise02.entities;

import lombok.Getter;
import lombok.Setter;

public abstract class RacingVehicles {
  @Getter protected double speed;

  @Getter @Setter protected String type;

  public RacingVehicles(double speed) {
    this.speed = speed;
  }
}
