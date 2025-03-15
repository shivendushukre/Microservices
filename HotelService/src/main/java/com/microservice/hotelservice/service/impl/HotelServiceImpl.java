package com.microservice.hotelservice.service.impl;

import com.microservice.hotelservice.entities.Hotel;
import com.microservice.hotelservice.repo.HotelRepo;
import com.microservice.hotelservice.service.HotelService;
import com.microservice.hotelservice.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;


    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return this.hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return this.hotelRepo.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return this.hotelRepo.findById(hotelId).orElseThrow(() ->
            new ResourceNotFoundException("Hotel with given id not found!!"));
    }
}
