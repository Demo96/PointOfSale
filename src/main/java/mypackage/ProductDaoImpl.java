package mypackage;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
	List<Product> products;

	public ProductDaoImpl() {
		products = new ArrayList<Product>();
		// ...retrieving data from database
	}

	@Override
	public List<Product> getAllProducts() {
		return products;
	}

	@Override
	public void updateProduct(Product p) {
		for (Product product : products)
			if (product.getBarCode() == p.getBarCode()) {
				product.setPrice(p.getPrice());
				product.setName(p.getName());
			}
	}

	@Override
	public void deleteProduct(Product p) {
		products.remove(p);
	}

	@Override
	public Product getProductByBarCode(String barCode) {
		for (Product product : products)
			if (product.getBarCode() == barCode)
				return product;
		return null;
	}

	@Override
	public Product getProductByName(String name) {
		for (Product product : products)
			if (product.getName() == name)
				return product;
		return null;
	}

	@Override
	public void addProduct(Product p) {
		products.add(p);
	}

}
