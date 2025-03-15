package com.microservice.hotelservice.controllers;

import com.microservice.hotelservice.entities.Hotel;
import com.microservice.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping()
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel serviceHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceHotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        Hotel serviceHotel = this.hotelService.getHotel(hotelId);
        return ResponseEntity.ok(serviceHotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(this.hotelService.getAll());
    }

}
