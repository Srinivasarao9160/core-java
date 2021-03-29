package com.produccts.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.produccts.model.Product;
import com.produccts.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@PostMapping("/addproducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}
	@GetMapping("/products")
	public List<Product> findAllProduct(){
		return service.getProducts();
	}
	@GetMapping("/productbyid/{id}")
    public Product findById(@PathVariable int id) {
		return service.getProductById(id);
	}
	@GetMapping("/productbyname/{name}")
    public Product findByName(@PathVariable String name) {
		return service.getProductByName(name);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	// Pagination
	@GetMapping("/getproductbyid")
    public ResponseEntity<List<Product>> getallStudentsPages(@RequestParam(defaultValue = "0") Integer pageNo,@RequestParam(defaultValue = "5") Integer pageSize) {
        List<Product> list = service.getAllProductPage(pageNo, pageSize);
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(),HttpStatus.OK);
    }
	
	
	
	
	
}
