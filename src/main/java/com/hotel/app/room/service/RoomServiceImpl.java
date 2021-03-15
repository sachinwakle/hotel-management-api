package com.hotel.app.room.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.app.room.dao.RoomDao;
import com.hotel.app.room.dto.RoomDto;
import com.hotel.app.roomoverview.dto.RoomOverviewDto;
import com.hotel.app.roomoverview.service.RoomOverviewService;

@Service
@Transactional(readOnly = true)
public class RoomServiceImpl implements RoomService {

    private static final Logger log = LoggerFactory.getLogger(RoomServiceImpl.class);
    private final RoomDao roomDao;
    private final RoomOverviewService roomOverviewService;

    public RoomServiceImpl(RoomDao roomDao, RoomOverviewService roomOverviewService) {
	this.roomDao = roomDao;
	this.roomOverviewService = roomOverviewService;
    }

    @Override
    public List<RoomDto> findRooms() {
	log.debug("Find all room records service");
	List<RoomDto> rooms = roomDao.findRooms();

	Map<Integer, List<RoomOverviewDto>> roomOverviewMap = roomOverviewService.findRoomOverview().stream()
		.collect(Collectors.groupingBy(RoomOverviewDto::getRoomId, Collectors.toList()));

	rooms.stream().forEach(room -> room.setRoomOverview(roomOverviewMap.get(room.getId())));
	return rooms;
    }

}
