package com.shekhar.projects.airBnbProject.Service;

import com.shekhar.projects.airBnbProject.Dto.BookingRequest;
import com.shekhar.projects.airBnbProject.Dto.BookingDto;
import com.shekhar.projects.airBnbProject.Dto.GuestDto;

import java.util.List;

public interface BookingService {
    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
