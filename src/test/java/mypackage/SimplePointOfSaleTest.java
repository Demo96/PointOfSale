package mypackage;



import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;


public class SimplePointOfSaleTest {
	private ScannerAdapter scannerAdapter;
	private SimplePointOfSale spos;

	@Before
	public void setup() {
		scannerAdapter = new ScannerAdapter();
		spos = Mockito.mock(SimplePointOfSale.class); // SimplePointOfSale(printer,display);
		scannerAdapter.addListener(spos);
	}

	@Test
	public void runExitWhenGetExitOnInput() {
		scannerAdapter.sendBarCode("exit");
		Mockito.verify(spos).exit();

	}
	@Test
	public void runScannedBarCodeWhenInput() {
		String barCode="123";
		String barCode2="";
		scannerAdapter.sendBarCode(barCode);
		scannerAdapter.sendBarCode(barCode2);
		Mockito.verify(spos).scannedBarCode(barCode);
		Mockito.verify(spos).scannedBarCode(barCode2);

	}
	@Test
	public void notRunListenerWhenInputNull() {
		scannerAdapter.sendBarCode(null);
		Mockito.verify(spos,Mockito.times(0)).scannedBarCode(Mockito.anyString());
		Mockito.verify(spos,Mockito.times(0)).exit();

	}

}
