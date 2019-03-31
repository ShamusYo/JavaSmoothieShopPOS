package smoothie_shop;

public class BananaSmoothie extends Smoothie {
	public BananaSmoothie() {
		description = " Banana Smoothie          ";
	}
	
	public double cost(String size) {
		if (size == "Large") {
			return 5.99;
		}
		if (size == "Medium") {
			return 4.99;
		}
		if (size == "Small") {
			return 3.99;
		}
		return 0;
	}
}
