package com.shekhar.projects.airBnbProject.Controller;


import com.shekhar.projects.airBnbProject.Dto.HotelDto;
import com.shekhar.projects.airBnbProject.Dto.RoomDto;
import com.shekhar.projects.airBnbProject.Service.HotelService;
import com.shekhar.projects.airBnbProject.Service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/hotels/{hotelId}/rooms")
@RequiredArgsConstructor
public class RoomAdminController {
    
    private final RoomService roomService;
    
    
    @PostMapping
    public ResponseEntity<RoomDto> createNewRoom(@PathVariable Long hotelId,
                                                 @RequestBody RoomDto roomDto){
       RoomDto room= roomService.createNewRoom(hotelId, roomDto);
       return new ResponseEntity<>(room, HttpStatus.CREATED);
        
    }
    
    @GetMapping("/allRooms")
    public ResponseEntity<List<RoomDto>> getAllRoomsInHotel(@PathVariable Long hotelId){
        return ResponseEntity.ok(roomService.getAllRoomsInHotel(hotelId));
        
    }
    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long hotelId,
                                               @PathVariable Long roomId){
        return ResponseEntity.ok(roomService.getRoomById(roomId));
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<RoomDto> deleteRoomById(@PathVariable Long hotelId, @PathVariable Long roomId) {
        roomService.deleteRoomById(roomId);
        return ResponseEntity.noContent().build();
    }
    
    
    
}
