package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.model.Review;

@Service
public class ReviewService {
	
	private Map<Integer , Review> reviewDb = new HashMap<>();
	
	public ReviewService(Map<Integer, Review> reviewDb) {
		super();
		this.reviewDb = reviewDb;
	}

	public void addReview( Review review) {
		
		reviewDb.put(review.getId(), review);
	}
	
	public void delReview (int id) {
		
		reviewDb.remove(id);
	}
	public Review getReview( Integer id) {
			
			return reviewDb.get(id);
		}
	
    public Collection<Review> getReviews( Review review) {
		
		return reviewDb.values();
	}
	public void updateReview(Review review) {
		reviewDb.put(review.getId(), review);
	}

    
	 public   Map<Integer , Review>  init () {
		 Map<Integer , Review> reviewMap = new HashMap<>();
		 
		 reviewMap.put(2, new Review( 1, "Book", 1, "Jiye", "I love this book :)", 10));
		 reviewMap.put(3, new Review( 2, "Pen", 2, "Max", "good", 9));
		 reviewMap.put(4, new Review( 3, "Pencil", 3, "Olivia", "disappointed :'(", 3));
		 reviewMap.put(5, new Review( 4, "Eraser", 4, "Tom", "Not bad", 6));
		 
		 return reviewMap;
			 
		}
}
