package sonvh.webservice.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Products {
	HashMap<String, Product> listProducts = new HashMap<String, Product>();

	public Products() {

		Product t = new Product();
		t.setId(1);
		t.setName("Máy tính để bàn ");
		listProducts.put("1", t);

		t = new Product();
		t.setId(2);
		t.setName("Smart phone Lumia 530");
		listProducts.put("2", t);

		t = new Product();
		t.setId(3);
		t.setName("Smart phone Lumia 550");
		listProducts.put("3", t);

		t = new Product();
		t.setId(3);
		t.setName("Điều hòa TOSIBA");
		t.setActive(false);
		listProducts.put("3", t);
	}

	public boolean update(Product group) {

		boolean flag = true;
		String key = String.valueOf(group.getId());
		if (listProducts.get(key) != null) {
			listProducts.replace(key, group);
		} else {
			// not exists
			flag = false;
		}
		return flag;
	}

	public boolean add(Product group) {

		boolean flag = true;
		String key = String.valueOf(group.getId());
		if (listProducts.get(key) == null) {
			listProducts.put(key, group);
		} else {
			// duplicate
			flag = false;
		}
		return flag;
	}

	public Product find_byID(int id) {

		Product result = listProducts.get(String.valueOf(id));

		return result;
	}

	public List<Product> find_byName(String name) {

		List<Product> result = new ArrayList<Product>();
		Iterator<?> i = listProducts.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			Product group= (Product)me.getValue();
			if ((group.getName().contains(name))) {
				result.add(group);
			}
		}
		return result;
	}

	public List<Product> getList() {
		List<Product> result = new ArrayList<Product>(listProducts.values());
		return result;
	}
}
