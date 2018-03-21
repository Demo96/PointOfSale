package mypackage;

public class LcdDisplay {
	private final String productNotFound="Product not found";
	private final String invalidBarCode="Invalid bar-code";
    public void displayProduct(Product product)
    {
    	display(product.getName()+"/t"+product.getPrice());
    }
    public void displayPrice(float price)
    {
    	display("Full Price:\t"+price);
    }
    public void displayProductNotFound()
    {
    	display(productNotFound);
    }
    public void displayInvalidBarCode()
    {
    	display(invalidBarCode);
    }
  //function displays given message on LCD display
    private void display(String message)
    {
    	//...
    }
}
