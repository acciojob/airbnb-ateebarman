package com.driver.repository;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class HotelManagementRepository {
    HashMap<String, Hotel> hotelHashMap = new HashMap<>();
    HashMap<Integer, User> userHashMap = new HashMap<>();
    HashMap<String, Booking> bookingHashMap = new HashMap<>();

    public String getHotelWithMostFacilities() {
        String hotelWithMostFacilities = "";
        int maxf = 0;
        for(Hotel hotel : hotelHashMap.values()){
            if(hotel.getFacilities().size()>maxf){
                maxf = hotel.getFacilities().size();
                hotelWithMostFacilities = hotel.getHotelName();
            }else if(hotel.getFacilities().size()==maxf){
                if(hotelWithMostFacilities.compareToIgnoreCase(hotel.getHotelName())>0){
                    hotelWithMostFacilities = hotel.getHotelName();
                }
            }

        }

        return hotelWithMostFacilities;
    }

    public Integer addUser(User user){
        userHashMap.put(user.getaadharCardNo(), user);
        return user.getaadharCardNo();


    }

    public void addHotel(Hotel hotel) {
        if (hotel == null || hotel.getHotelName() == null
                || hotel.getHotelName().isEmpty()) {
            throw new IllegalArgumentException("Invalid hotel");
        }
        String name = hotel.getHotelName();
        if (hotelHashMap.containsKey(name)) {
            throw new IllegalArgumentException("Hotel already exists");
        }

        hotelHashMap.put(name, hotel);

    }

    public int bookARoom(Booking booking) {
        bookingHashMap.put(booking.getBookingId(), booking);
        return booking.getAmountToBePaid();
    }

    public Hotel getHotel(String hotelName) {

        return hotelHashMap.get(hotelName);
    }

    public int getBookings(Integer aadharCard) {
        int count = 0;

        for(Booking booking : bookingHashMap.values()){
            if(booking.getBookingAadharCard() == aadharCard){
                count++;
            }
        }

        return count;
    }

    public Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {
        Hotel h = hotelHashMap.get(hotelName);
        for(Facility facility : newFacilities){
            if(!h.getFacilities().contains(facility)){
                h.getFacilities().add(facility);
            }
        }

        return h;
    }
}
