package com.pack;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	Set<Product> products=new HashSet<Product>();
	
	ProductService(){
		products.add(new Product(56, "Bolts", "B des", "abc", "a@yahoo.com", 4500));
		products.add(new Product(34, "nuts", "C desc", "xyz", "b@yahoo.com", 6000));
	}
	public Set<Product> getProduct(){
		return products;
	}
	
	public Product getProductById(int id) {
		Product prod=products.stream().filter(p->p.getId()==id).findAny().orElse(null);
		
		return prod;
				}
	
	public Product addProduct(Product prod) {
		Random r=new Random();
		prod.setId(r.nextInt(200));
		products.add(prod);
		return prod;
	}
	
	public void removeProduct(Product prod) {
		products.remove(prod);
	}


}
