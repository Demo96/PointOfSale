package mypackage;

import static org.junit.Assert.*;

import java.awt.print.PrinterException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PrinterTest {
	private Printer printer;
	private LcdDisplay display;
	private ScannerAdapter scannerAdapter;
	private ProductDao pd;
	private SimplePointOfSale spos;

	@Before
	public void setup() {
		scannerAdapter = new ScannerAdapter();
		printer = Mockito.mock(Printer.class);
		display = new LcdDisplay();
		pd = new ProductDaoImpl();
		// adding test data
		Product Product1=new Product("123", "mleko", 2.20f);
		Product Product2=new Product("9999999", "baton Mars", 1.50f);
		Product Product3=new Product("01234", "chipsy Lays 225g", 5.99f);
		pd.addProduct(Product1);
		pd.addProduct(Product2);
		pd.addProduct(Product3);
		spos = new SimplePointOfSale(printer, display, pd);
		scannerAdapter.addListener(spos);
	}

	@Test
	public void printReceiptWhenInputIsExit() {
		scannerAdapter.sendBarCode("exit");
		try {
			Mockito.verify(printer).printReceipt();
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void countPriceReturnsSummedUpPrice() {
		scannerAdapter.sendBarCode("123");
		scannerAdapter.sendBarCode("123");
		scannerAdapter.sendBarCode("01234");
		Printer printer2 = new Printer();
		printer2.setProducts(spos.getReceipt());
		assertEquals(printer2.countPrice(), 2.20 + 2.20 + 5.99, 0.009f);
	}

}
