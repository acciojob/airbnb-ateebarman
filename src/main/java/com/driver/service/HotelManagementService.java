package com.driver.service;

import com.driver.dto.request.BookingReq;
import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;
import com.driver.repository.HotelManagementRepository;
import com.driver.transformers.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelManagementService {

    @Autowired
    private HotelManagementRepository hotelManagementRepository;

    public String addHotel(Hotel hotel) {
        hotelManagementRepository.addHotel(hotel);
        return hotel.getHotelName();
    }

    public Integer addUser(User user) {
        return hotelManagementRepository.addUser(user);
    }

    public String getHotelWithMostFacilities() {
        return hotelManagementRepository.getHotelWithMostFacilities();
    }

    public int getBookings(Integer aadharCard) {

        return hotelManagementRepository.getBookings(aadharCard);

    }

    public int bookARoom(BookingReq bookingReq) {
        Booking booking = BookingTransformer.bookingReqToBooking(bookingReq);
        String hotelName = booking.getHotelName();
        Hotel hotel = hotelManagementRepository.getHotel(hotelName);
        if (hotel == null) {
            throw new RuntimeException("Hotel not found");
        }
        if(hotel.getAvailableRooms() < bookingReq.getNoOfRooms()){
            throw new RuntimeException("rooms are not enough");
        }
        hotel.setAvailableRooms(hotel.getAvailableRooms() - bookingReq.getNoOfRooms());
        int price = hotel.getPricePerNight();
        int totalAmount = price * booking.getNoOfRooms();
        booking.setAmountToBePaid(totalAmount);

        return hotelManagementRepository.bookARoom(booking);

    }

    public Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {
        return hotelManagementRepository.updateFacilities(newFacilities,hotelName);
    }
}
