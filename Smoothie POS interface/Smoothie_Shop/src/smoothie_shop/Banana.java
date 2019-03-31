package smoothie_shop;

public class Banana extends IngredientDecorator {
	Smoothie smoothie;
	
	public Banana(Smoothie smoothie) {
		this.smoothie = smoothie;
	}
	
	public String getDescription() {
		return "+ Banana ";
	}
	
	public double cost(String size) {
		return 1.00;
	}
}