package com.shekhar.projects.airBnbProject.Service;

import com.shekhar.projects.airBnbProject.Dto.HotelDto;
import com.shekhar.projects.airBnbProject.Dto.HotelInfoDto;
import com.shekhar.projects.airBnbProject.Dto.RoomDto;
import com.shekhar.projects.airBnbProject.Entity.Hotel;
import com.shekhar.projects.airBnbProject.Entity.Room;
import com.shekhar.projects.airBnbProject.Repository.HotelRepository;
import com.shekhar.projects.airBnbProject.Repository.RoomRepository;
import com.shekhar.projects.airBnbProject.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelServiceImp implements HotelService{
    
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    
    private final InventoryService inventoryService;
    
    private final RoomRepository roomRepository;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating a new Hotel with name: {}",hotelDto.getName());
        Hotel hotel = modelMapper.map(hotelDto,Hotel.class);
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel);
        log.info("Created a new hotel with ID: {}", hotelDto.getId());
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting hotel with id: {}",id);
        Hotel hotel =hotelRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Hotel not find by id: "+id));

        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating the hotel with ID: {}",id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+id));
        modelMapper.map(hotelDto,hotel);
        hotel.setId(id);
        hotel = hotelRepository.save(hotel);
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Transactional
    @Override
    public void deleteHotelById(Long hotelId) {
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));
        for(Room room: hotel.getRooms()) {
            inventoryService.deleteAllInventories(room);
            roomRepository.deleteById(room.getId());
        }
        hotelRepository.deleteById(hotelId);
    }
    
    @Override
    @Transactional
    public void activateHotel(Long hotelId) {
        log.info("Activating the hotel with ID: {}",hotelId);
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()->
                new ResourceNotFoundException("Hotel are not found with id: " +hotelId));
        hotel.setActive(true);

        for(Room room: hotel.getRooms()) {
            inventoryService.initializeRoomForAYear(room);
        }
    }

    @Override
    public HotelInfoDto getHotelInfoById(Long hotelId) {
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));

        List<RoomDto> rooms = hotel.getRooms()
                .stream()
                .map((element) -> modelMapper.map(element, RoomDto.class))
                .toList();

        return new HotelInfoDto(modelMapper.map(hotel, HotelDto.class), rooms);
    }



}
