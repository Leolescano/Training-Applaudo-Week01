package exercise03.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class User extends Element {

  @Getter @Setter private String firstName;

  @Getter @Setter private String lastName;

  public User(String username, String firstName, String lastName) {
    super(username);
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return String.format(
        """
				--------------------
				User name : %s
				First name: %s
				Last name: %s
				------------------------
				""",
        this.name, this.firstName, this.lastName);
  }
}
