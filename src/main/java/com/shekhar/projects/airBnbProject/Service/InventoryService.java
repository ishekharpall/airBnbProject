package com.shekhar.projects.airBnbProject.Service;

import com.shekhar.projects.airBnbProject.Dto.HotelDto;
import com.shekhar.projects.airBnbProject.Dto.HotelSearchRequest;
import com.shekhar.projects.airBnbProject.Entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {
    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);
    
}
