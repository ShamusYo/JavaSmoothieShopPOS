package smoothie_shop;

public class StrawberrySmoothie extends Smoothie {
	public StrawberrySmoothie() {
		description = " Strawberry Smoothie     ";
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
