package smoothie_shop;

public class Strawberry extends IngredientDecorator {
	Smoothie smoothie;
	
	public Strawberry(Smoothie smoothie) {
		this.smoothie = smoothie;
	}
	
	public String getDescription() {
		return "+ Strawberry ";
	}
	
	public double cost(String size) {
		return 1.00;
	}
}
