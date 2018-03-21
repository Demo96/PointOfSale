package mypackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductDaoTest {
	private ProductDao pd;
	private Product product1=new Product("123", "mleko", 2.20f);
	private Product product2=new Product("9999999", "baton Mars", 1.50f);
	private Product product3=new Product("01234", "chipsy Lays 225g", 5.99f);
	@Test
	public void getAllProductsHasAppropriateSizeAfterAddDelete() {
	pd=new ProductDaoImpl();
	assertEquals(pd.getAllProducts().size(),0);
	pd.addProduct(product1);
	assertEquals(pd.getAllProducts().size(),1);
	pd.addProduct(product2);
	assertEquals(pd.getAllProducts().size(),2);
	pd.deleteProduct(product1);
	assertEquals(pd.getAllProducts().size(),1);
	}
	@Test
	public void getProductByNameReturnsAppropriateProduct() {
	pd=new ProductDaoImpl();
	pd.addProduct(product3);
	assertEquals(pd.getProductByName("chipsy Lays 225g"),product3);
	}
	@Test
	public void getProductByBarCodeReturnsAppropriateProduct() {
	pd=new ProductDaoImpl();
	pd.addProduct(product3);
	pd.addProduct(product1);
	assertEquals(pd.getProductByBarCode("01234"),product3);
	}
	@Test
	public void updateProductTest() {
	pd=new ProductDaoImpl();
	pd.addProduct(product1);
	Product temp=pd.getProductByBarCode("123");
	temp.setName("not milk");
	pd.updateProduct(temp);
	assertEquals(pd.getProductByBarCode("123").getName(),"not milk");
	}
	
	

}
