package smoothie_shop;

public abstract class Smoothie {
	String description = "Smoothie";

	// Smoothie is an abstract class with two methods
	public String getDescription() {
		return description;
	}

	public abstract double cost(String size);
}