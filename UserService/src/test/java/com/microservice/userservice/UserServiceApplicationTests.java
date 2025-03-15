package com.microservice.userservice;

import com.microservice.userservice.entities.Rating;
import com.microservice.userservice.external.services.RatingService;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}

//	@Test
//	void createRating() {
//		Rating rating = Rating.builder().rating(10)
//				.userId("")
//				.hotelId("")
//				.feedback("This is created using feign client")
//				.build();
//		Rating newRating = ratingService.createRating(rating);
//		System.out.println("New rating created");
//	}
}
