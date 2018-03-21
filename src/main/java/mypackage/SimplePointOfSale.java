package mypackage;

import java.awt.print.PrinterException;
import java.util.ArrayList;

public class SimplePointOfSale implements ScannerListener {
	private Printer printer;
	private LcdDisplay lcdDisplay;
	private ProductDao productDao;
	private ArrayList<Product> receipt;

	public SimplePointOfSale(Printer printer, LcdDisplay lcdDisplay, ProductDao productDao) {
		this.printer = printer;
		this.lcdDisplay = lcdDisplay;
		this.productDao = productDao;
		receipt = new ArrayList<Product>();
	}

	@Override
	public void scannedBarCode(String barCode) {
		if (barCode != null) {
			if (barCode.length() == 0)
				lcdDisplay.displayInvalidBarCode();
			else if (productDao.getProductByBarCode(barCode) != null) {
				lcdDisplay.displayProduct(productDao.getProductByBarCode(barCode));
				receipt.add(productDao.getProductByBarCode(barCode));
			} else
				lcdDisplay.displayProductNotFound();
		} else
			lcdDisplay.displayInvalidBarCode();
	}

	@Override
	public void exit() {
		printer.setProducts(receipt);
		float temp = 0;
		for (Product product : receipt)
			temp += product.getPrice();
		lcdDisplay.displayPrice(temp);
		try {
			printer.printReceipt();
		} catch (PrinterException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Product> getReceipt() {
		return receipt;
	}

	public void setReceipt(ArrayList<Product> receipt) {
		this.receipt = receipt;
	}

}
