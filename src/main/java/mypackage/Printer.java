package mypackage;

import java.awt.print.PrinterException;
import java.util.ArrayList;

import javax.swing.JTextPane;

public class Printer {
	private ArrayList<Product> products = new ArrayList<Product>();

	public float countPrice() {
		float sum = 0;
		for (Product product : products)
			sum += product.getPrice();
		return sum;

	}

	public void printReceipt() throws PrinterException {
		String toPrint = "";
		for (Product product : products)
			toPrint += product.getName() + "\tprice: " + product.getPrice() + "\n";
		toPrint += "**********************\n";
		toPrint += "Full price:\t" + countPrice();
		JTextPane textPane = new JTextPane();
		textPane.setText(toPrint);
		textPane.print();
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}
