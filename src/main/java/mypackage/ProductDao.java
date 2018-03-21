package mypackage;

import java.util.List;

public interface ProductDao {
	public List<Product> getAllProducts();

	public Product getProductByBarCode(String barCode);

	public Product getProductByName(String name);

	public void updateProduct(Product p);

	public void deleteProduct(Product p);

	public void addProduct(Product p);
}
