package com.pack;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	//@GetMapping(value="/products",produces=MediaType.APPLICATION_XML_VALUE)
	@GetMapping("/product")
	public Set<Product> getProducts(){
		
		return productService.getProduct();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
	  Product prod=	productService.getProductById(id);
	  if(prod==null) {
		  return new ResponseEntity<Product>(prod,HttpStatus.NOT_FOUND);
	  }
	  else {
		  return new ResponseEntity<Product>(prod,HttpStatus.OK);
	  }
	}
	@PostMapping("/product/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Product addProduct(@RequestBody Product prod) {
		return productService.addProduct(prod);
	}
	
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product productDetails,@PathVariable int id) {
	  Product prod=	productService.getProductById(id);
	  if(prod==null) return new ResponseEntity<Product>(prod,HttpStatus.NOT_FOUND);
	  else {
		  prod.setName(productDetails.getName());
		  prod.setDesc(productDetails.getDesc());
		  prod.setPrice(productDetails.getPrice());
		  prod.setSeller(productDetails.getSeller());
		  prod.setEmail(productDetails.getEmail());
		  return new ResponseEntity<Product>(prod,HttpStatus.OK);
	  }

	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Object>deleteProduct(@PathVariable int id){
		Product prod=productService.getProductById(id);
		if(prod==null) return ResponseEntity.notFound().build();
		
		else {
			productService.removeProduct(prod);
			return ResponseEntity.ok().build();
		}
		
	}
	
}
