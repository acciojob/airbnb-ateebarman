package com.driver.transformers;

import com.driver.dto.request.BookingReq;
import com.driver.model.Booking;

import java.util.UUID;

public class BookingTransformer {
    public static Booking bookingReqToBooking(BookingReq bookingReq){
        Booking booking = new Booking();
        booking.setHotelName(bookingReq.getHotelName());
        booking.setBookingPersonName(bookingReq.getBookingPersonName());
        booking.setBookingAadharCard(bookingReq.getBookingAadharCard());
        booking.setNoOfRooms(bookingReq.getNoOfRooms());

        booking.setBookingId(UUID.randomUUID().toString());
        return booking;

    }
}
