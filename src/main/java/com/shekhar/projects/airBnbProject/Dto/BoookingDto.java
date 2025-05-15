package com.shekhar.projects.airBnbProject.Dto;

import com.shekhar.projects.airBnbProject.Entity.*;
import com.shekhar.projects.airBnbProject.Entity.enums.BookingStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BoookingDto {

    private Long id;
    private Hotel hotel;
    private Room room;
    private User user;
    private Integer roomCount;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BookingStatus bookingStatus;
    private Set<GuestDto> guests;


}
