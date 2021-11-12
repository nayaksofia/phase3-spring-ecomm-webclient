package com.simplilearn.webclient.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.simplilearn.webclient.entiry.Product;

@RestController
@RequestMapping("/api/v1/consume/")
public class ProductConsumerController {

	@GetMapping("/product/{id}")
	public Product fetchProduct(@PathVariable("id") long id) {
		
	//1. Define URL
		String url = "http://localhost:9000/products/" + id;
	//2. Use REST Template
		RestTemplate restTemplate = new RestTemplate();
			
    //3. Map response to product entity
		
	   Product product = restTemplate.getForObject(url, Product.class);
		
		return product;
	}
	
	@PutMapping("/product")
	public void  updateProduct(@RequestBody Product product){
		
		//1. Define URL
				String url = "http://localhost:9000/products/";
	   
		//2. Use REST Template
				RestTemplate restTemplate = new RestTemplate();
			
				restTemplate.put(url, product);
	}
	
}
