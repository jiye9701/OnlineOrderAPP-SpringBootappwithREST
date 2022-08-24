package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class ProductService {
	
	private Map<Integer , Product> productDb = new HashMap<>();
	
	public ProductService(Map<Integer, Product> productDb) {
		super();
		this.productDb = productDb;
	}

	public void addProduct( Product product) {
		
		productDb.put(product.getId(), product);
	}
	
	public void delProduct (int id) {
		
		productDb.remove(id);
	}
	
	public Product getProduct( Integer id) {
			
			return productDb.get(id);
		}
	public Product deleteProduct( int id) {
		
		return productDb.remove(id);
	}
    public Collection<Product> getProducts( Product product) {
		
		return productDb.values();
	}
	public void updateProduct(Product product) {
		productDb.put(product.getId(), product);
	}
    
    public Iterable<Product> getProducts(){
        return productDb.values();
    }
    
	 public   Map<Integer , Product>  init () {
		 Map<Integer , Product> productMap = new HashMap<>();
		 
		 productMap.put(2, new Product( 1, "Book", 80.5, 5));
		 productMap.put(3, new Product( 2, "Pen", 3, 30));
		 productMap.put(4, new Product( 3, "Pencil", 2, 12));
		 productMap.put(5, new Product( 4, "Eraser", 1.25, 10));
		 
		 return productMap;
			 
		}
	 public interface ProductRepository extends JpaRepository<Product, Integer> {

		}
}
