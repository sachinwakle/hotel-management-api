package com.hotel.app.roomoverview.dao;

import java.util.List;

import com.hotel.app.roomoverview.dto.RoomOverviewItemDto;

public interface RoomOverviewDao {

    public List<RoomOverviewItemDto> findRoomOverview();
}
