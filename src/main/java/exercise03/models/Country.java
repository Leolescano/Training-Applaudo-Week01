package exercise03.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Country extends Element {

	@Getter @Setter
	private String isoCode;

	public Country(String name, String isoCode) {
		super(name);
		this.isoCode = isoCode;
	}

	@Override
	public String toString() {
		return String.format("""
				------------------------
				Country Name: %s
				ISO Code: %s
				------------------------
				""", this.name, this.isoCode);
	}
}
