package com.microservice.RatingService.services;

import com.microservice.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    // create
    Rating createRating(Rating rating);

    // get all rating
    List<Rating> getRatings();

    // get all by user ID
    List<Rating> getRatingByUserId(String userId);

    // get all by hotel ID
    List<Rating> getRatingByHotelId(String hotelId);
}
