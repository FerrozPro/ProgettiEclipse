package it.ferroz.groceryshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GroceryShop {

	private static List<String> barCodeList = new ArrayList<String>();

	private Map<Product, Integer> productMap = new HashMap<Product, Integer>();

	/* Constructor */
	public GroceryShop() {

	}

	/* Methods */
	private String generateBarCode() {
		return String.valueOf(Math.random() * 1000000000);
	}

	public String generateValidBarCode() {
		String res = generateBarCode();
		while (barCodeList.contains(res)) {
			res = generateBarCode();
		}
		return res;
	}

	public Map<Product, Integer> getProductMap() {
		return productMap;
	}
	
	public void printProductMap() {
		for (Entry<Product, Integer> entry : productMap.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}

	public void addProduct(Product product, Integer quantity) {
		if (!productMap.containsKey(product)) {
			productMap.put(product, quantity);
		} else {
			productMap.replace(product, productMap.get(product) + quantity);
		}
	}

	public Set<Product> getSetProduct() {
		return productMap.keySet();
	}

}
