package com.shekhar.projects.airBnbProject.Service;

import com.shekhar.projects.airBnbProject.Dto.HotelDto;
import com.shekhar.projects.airBnbProject.Dto.HotelInfoDto;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);
    
    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);
    
    void deleteHotelById(Long hotelId);
    
    void activateHotel(Long hotelId);

    HotelInfoDto getHotelInfoById(Long hotelId);
}
