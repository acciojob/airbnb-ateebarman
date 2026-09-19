package com.driver.dto.request;

public class BookingReq {
    //This will be a random UUID generated String
    private int bookingAadharCard;

    private int noOfRooms;

    private String bookingPersonName;

    private String hotelName;

    public BookingReq() {
    }

    public BookingReq(int bookingAadharCard, int noOfRooms, String bookingPersonName, String hotelName) {
        this.bookingAadharCard = bookingAadharCard;
        this.noOfRooms = noOfRooms;
        this.bookingPersonName = bookingPersonName;
        this.hotelName = hotelName;
    }

    public int getBookingAadharCard() {
        return bookingAadharCard;
    }

    public void setBookingAadharCard(int bookingAadharCard) {
        this.bookingAadharCard = bookingAadharCard;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getBookingPersonName() {
        return bookingPersonName;
    }

    public void setBookingPersonName(String bookingPersonName) {
        this.bookingPersonName = bookingPersonName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
