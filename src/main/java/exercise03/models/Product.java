package exercise03.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Product extends Element {

  @Getter @Setter private int stock;

  public Product(String name, int stock) {
    super(name);
    this.stock = stock;
  }

  @Override
  public String toString() {
    return String.format(
        """
				-------------------
				Product	Name: %s
				Stock: %d
				------------------------
				""",
        this.name, this.stock);
  }
}
