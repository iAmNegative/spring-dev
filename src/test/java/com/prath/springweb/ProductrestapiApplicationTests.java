package com.prath.springweb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.prath.springweb.entities.Product;

@SpringBootTest
class ProductrestapiApplicationTests {

	@Test
	void contextLoads() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:8080/productapi/products/1",Product.class);
		assertNotNull(product);
		assertEquals("Iphone",product.getName());
	}
	
	@Test
	void testCreate() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Realme");
		product.setDescription("it Real");
		product.setPrice(450);
		Product newproduct = restTemplate.postForObject("http://localhost:8080/productapi/products/", product, Product.class);
		assertNotNull(newproduct);
		assertEquals("Realme",newproduct.getName());
	}
	@Test
	void testUpdate() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:8080/productapi/products/1",Product.class);
		product.setPrice(1500);
		
		restTemplate.put("http://localhost:8080/productapi/products/",product);
		assertNotNull(product);
		assertEquals(1500,product.getPrice());
	}

}
