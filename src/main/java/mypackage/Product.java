package mypackage;

public class Product {
	private String barCode;
	private String name;
	private float price;

	public Product(String bC, String n, float p) {
		barCode = bC;
		name = n;
		price = p;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
