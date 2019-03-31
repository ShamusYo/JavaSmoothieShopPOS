package smoothie_shop;

public class AcaiBerry extends IngredientDecorator {
	Smoothie smoothie;
	
	public AcaiBerry(Smoothie smoothie) {
		this.smoothie = smoothie;
	}
	
	public String getDescription() {
		return  "+ Acai Berry ";
	}
	
	public double cost(String size) {
		return 1.00;
	}
}