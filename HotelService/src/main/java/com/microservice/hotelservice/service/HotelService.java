package com.microservice.hotelservice.service;

import com.microservice.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotel(String hotelId);
}
