package mypackage;

public class BarCodesScanner {
	private ScannerAdapter scannerAdapter;

	public void getBarCode() {
		String barCode = readBarCode();
		scannerAdapter.sendBarCode(barCode);
	}

	// reads barcode using scanner
	public String readBarCode() {
		// getting input form scanner implementation
		//...
		return null;
	}
}
