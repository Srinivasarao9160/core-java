package com.produccts.service;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.produccts.dao.ProductDao;
import com.produccts.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productRepo;

	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return productRepo.saveAll(products);
	}

	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	public Product getProductById(int id) {
		return productRepo.findById(id).orElse(null);
	}

	public Product getProductByName(String name) {
		return productRepo.findByName(name);
	}

	public String deleteProduct(int id) {
		productRepo.deleteById(id);
		return "product removed" +id;
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct=productRepo.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setCost(product.getCost());
		existingProduct.setQuentity(product.getQuentity());
		
		return productRepo.save(existingProduct);
	}
	
	// Pagination
	public List<Product> getAllProductPage(Integer pageNo,Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> list = productRepo.findAll(pageable);
        if(list.hasContent()) {
            return list.getContent();
        }
        else {
            return new ArrayList<Product>();
        }
    }
	
	}
	
	
	
	
	
