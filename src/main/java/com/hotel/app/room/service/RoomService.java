package com.hotel.app.room.service;

import java.util.List;

import com.hotel.app.room.dto.RoomDto;

public interface RoomService {

    public List<RoomDto> findRooms();
}
