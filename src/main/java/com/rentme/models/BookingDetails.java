package com.rentme.models;

import com.rentme.utils.Status;
import com.rentme.validators.StatusConstraint;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class BookingDetails {

    @Id
    String bookingId = UUID
            .randomUUID()
            .toString()
            .replace("-","")
            .toUpperCase();

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "customerId")
    Customer customer;

    @OneToOne
    @JoinColumn(name = "vehicle_id", nullable = false, referencedColumnName = "registrationId")
    Vehicle vehicle;

    @PastOrPresent
    @NotNull
    LocalDateTime bookingTime;

    @FutureOrPresent
    @NotNull
    LocalDateTime fromTime;

    @FutureOrPresent
    @NotNull
    LocalDateTime toTime;

    @StatusConstraint
    Status status;

    public void setStatus(String status) {
        switch(status){
            case "SUBMITTED": this.status = Status.SUBMITTED;break;
            case "CANCELLED": this.status = Status.CANCELLED;break;
            case "COMPLETED": this.status = Status.COMPLETED;break;
        }
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public LocalDateTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalDateTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalDateTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalDateTime toTime) {
        this.toTime = toTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
