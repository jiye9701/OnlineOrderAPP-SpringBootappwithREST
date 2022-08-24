package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.ProductService;
import com.example.demo.ReviewService;
import com.example.demo.model.Product;
import com.example.demo.model.Review;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ReviewService reviewService;
	
	public MainController() {
		super();
		getProducts();
		getReviews();
	}

	private void getProducts() {
		
		this.products.add( new Product( 1, "Book", 80.5, 5));
		this.products.add( new Product( 2, "Pen", 3, 30));
		this.products.add( new Product( 3, "Pencil", 2, 12));
		this.products.add( new Product( 4, "Eraer", 1.25, 10));
		
	}

	List<Product> products  = new ArrayList();
	
	//Review
	private void getReviews() {
		
		this.reviews.add( new Review( 1, "Book", 1, "Jiye", "I love this book :)", 10));
		this.reviews.add( new Review( 2, "Pen", 2, "Max", "good", 9));
		this.reviews.add( new Review( 3, "Pencil", 3, "Olivia", "disappointed :'(", 3));
		this.reviews.add( new Review( 4, "Eraser", 4, "Tom", "Not bad", 6));
		
	}

	List<Review> reviews  = new ArrayList();
	
	
	
	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
	
	@RequestMapping("/review")
	public String review() {
		
		return "review";
	}
	
	
	//get
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    Iterable<Product> getProduct() {
        return productService.getProducts();
    }
    
	//post-products
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct (@ModelAttribute Product product) {
		
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());
		
		
		products.add(product);
		//productService 
		return "review";
		
	}
	
	//post-reviews
	@RequestMapping(value = "/add2", method = RequestMethod.POST)
	public String addReview(@ModelAttribute Review review) {
		
		System.out.println(review.getId());
		System.out.println(review.getName());
		
		System.out.println(review.getUserNo());
		System.out.println(review.getUser());
		System.out.println(review.getComment());
		System.out.println(review.getRating());
		
		reviews.add(review);
		//reviewService 
		return "review2";
		
	}
	
	
	//all info Get
	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)
	public String info(@ModelAttribute Review review, Product product, Model m) {
		
//		System.out.println(product.getId());
//		System.out.println(product.getName());
//		
//		System.out.println(review.getUserNo());
//		System.out.println(review.getUser());
//		System.out.println(review.getComment());
//		System.out.println(review.getRating());
		
//		products.add(product);
//		reviews.add(review);
		
//		Product admin = new Product(1, "Book", 50, 100);
//		Review admin2 = new Review(1, "admin", "example", 100);
		
//		m.addAttribute("message" , "Hello world");
//		m.addAttribute("admin" , admin);
		m.addAttribute("products", products);
		m.addAttribute("reviews", reviews);
		
//		m.addAttribute("admin2" , admin2);
		
		return "myview";
		
	}
	

	
	
	//delete
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String delete (@ModelAttribute Product product, Review review) {
		
		
		products.remove(product.getId());
		reviews.remove(review.getId());
		//productService 
		return "review";
		
	}
	
	//put
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateProduct (@ModelAttribute Product product, Review review) {
		
		products.set(product.getId(), product);
		reviews.set(review.getId(), review);
		return "review";
		
	}
	
	
}
