package com.microservice.userservice.external.services;

import com.microservice.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    // post rating
    @PostMapping("/ratings")
    public Rating createRating(Rating rating);

}
