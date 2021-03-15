package com.hotel.app.room.dao;

import java.util.List;

import com.hotel.app.room.dto.RoomDto;

public interface RoomDao {
    public List<RoomDto> findRooms();
}
