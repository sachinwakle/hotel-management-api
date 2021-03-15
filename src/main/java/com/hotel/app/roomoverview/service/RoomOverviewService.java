package com.hotel.app.roomoverview.service;

import java.util.List;

import com.hotel.app.roomoverview.dto.RoomOverviewDto;

public interface RoomOverviewService {

    public List<RoomOverviewDto> findRoomOverview();
}
