package com.hotel.app.roomoverview.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.app.roomoverview.dao.RoomOverviewDao;
import com.hotel.app.roomoverview.dto.RoomOverviewDto;
import com.hotel.app.roomoverview.dto.RoomOverviewItemDto;
import com.hotel.app.roomoverview.dto.RoomOverviewSubItemDto;

@Service
@Transactional(readOnly = true)
public class RoomOverviewServiceImpl implements RoomOverviewService {

    private static final Logger log = LoggerFactory.getLogger(RoomOverviewServiceImpl.class);

    private final RoomOverviewDao roomOverviewDao;

    public RoomOverviewServiceImpl(RoomOverviewDao roomOverviewDao) {
	this.roomOverviewDao = roomOverviewDao;
    }

    @Override
    public List<RoomOverviewDto> findRoomOverview() {
	log.debug("Request in RoomOverview Service");
	List<RoomOverviewItemDto> roomOverviewItemDtoList = roomOverviewDao.findRoomOverview();

	Map<Integer, List<RoomOverviewItemDto>> roomItems = roomOverviewItemDtoList.stream()
		.collect(Collectors.groupingBy(RoomOverviewItemDto::getId, Collectors.toList()));

	return roomItems.entrySet().stream().map(e -> {
	    RoomOverviewItemDto itemDto = e.getValue().get(0); // 1.

	    List<RoomOverviewSubItemDto> subItems = e.getValue().stream().map((RoomOverviewItemDto subitem) -> {
		return new RoomOverviewSubItemDto(subitem.getSubItemName(), subitem.getSubItems());
	    }).collect(Collectors.toList()); // 2.

	    return new RoomOverviewDto(itemDto, subItems);
	}).collect(Collectors.toList());

    }

}
