package mypackage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class LcdDisplayTest {
	private Printer printer;
	private LcdDisplay display;
	private ScannerAdapter scannerAdapter;
	private ProductDao pd;
	private SimplePointOfSale spos;
	private Product product1=new Product("123", "mleko", 2.20f);
	private Product product2=new Product("9999999", "baton Mars", 1.50f);
	private Product product3=new Product("01234", "chipsy Lays 225g", 5.99f);
	@Before
	public void setup() {
		scannerAdapter = new ScannerAdapter();
		printer = new Printer();
		display = Mockito.mock(LcdDisplay.class);
		pd = new ProductDaoImpl();
		// adding test data
		pd.addProduct(product1);
		pd.addProduct(product2);
		pd.addProduct(product3);
		spos = new SimplePointOfSale(printer, display, pd);
		scannerAdapter.addListener(spos);
	}
	@Test
	public void displayFullPriceWhenInputIsExit() {
		
		scannerAdapter.sendBarCode("9999999");
		scannerAdapter.sendBarCode("9999999");
		scannerAdapter.sendBarCode("exit");
		Mockito.verify(display).displayPrice(2*1.5f);
	}
	@Test
	public void displayFullPriceZero() {
		scannerAdapter.sendBarCode("exit");
		Mockito.verify(display).displayPrice(0);
	}
	@Test
	public void displayInvalidBarCode() {
		
		scannerAdapter.sendBarCode("");
		Mockito.verify(display).displayInvalidBarCode();
	}
	@Test
	public void displayProductNotFound() {
		
		scannerAdapter.sendBarCode("555555555");
		Mockito.verify(display).displayProductNotFound();
	}
	@Test
	public void displayProductNameAndPrice() {
		scannerAdapter.sendBarCode("01234");
		Mockito.verify(display).displayProduct(product3);
	}

}
