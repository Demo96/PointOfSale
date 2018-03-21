package mypackage;

import java.util.ArrayList;
import java.util.List;

public class ScannerAdapter {
	public List<ScannerListener> listeners = new ArrayList<ScannerListener>();

	public synchronized void addListener(ScannerListener toAdd) {
		listeners.add(toAdd);
	}

	public synchronized void sendBarCode(String s) {
		if (s != null) {
			if (!s.equals("exit"))
				for (ScannerListener sl : listeners)
					sl.scannedBarCode(s);
			else
				for (ScannerListener sl : listeners)
					sl.exit();
		}
	}
}
