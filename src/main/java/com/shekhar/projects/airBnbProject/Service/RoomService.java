package com.shekhar.projects.airBnbProject.Service;

import com.shekhar.projects.airBnbProject.Dto.RoomDto;

import java.util.List;

public interface RoomService {
    
    RoomDto createNewRoom(Long hotelId,RoomDto roomDto);

    List<RoomDto> getAllRoomsInHotel(Long hotelId);
    
    RoomDto getRoomById(Long roomId);
    
    void deleteRoomById(Long roomId);
    
    
}
