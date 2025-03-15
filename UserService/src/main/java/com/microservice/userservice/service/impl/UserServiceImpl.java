package com.microservice.userservice.service.impl;

import com.microservice.userservice.entities.Hotel;
import com.microservice.userservice.entities.Rating;
import com.microservice.userservice.entities.User;
import com.microservice.userservice.exception.ResourceNotFoundException;
import com.microservice.userservice.external.services.HotelService;
import com.microservice.userservice.repositories.UserRepo;
import com.microservice.userservice.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser(User user) {
        // generate unique user Id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new
                ResourceNotFoundException("User with given ID: "
                + userId + "not found!!"));
        // fetch rating of the above user from Rating service
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{}", (Object) ratingsOfUser);

        assert ratingsOfUser != null;
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().peek(rating -> {
            // api call to hotel service
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            // set hotel to rating
            rating.setHotel(hotel);

            // return new Rating
        }).toList();


        user.setRatings(ratingList);
        return user;
    }
}
