package com.hotel.app.roomoverview.dao;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hotel.app.roomoverview.dto.RoomOverviewItemDto;

@Component
public class RoomOverviewMapper implements RowMapper<RoomOverviewItemDto> {

    @Override
    public RoomOverviewItemDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	RoomOverviewItemDto roomOverviewItemDto = new RoomOverviewItemDto();
	roomOverviewItemDto.setCreatedOn(resultSet.getTimestamp(RoomOverviewDaoImpl.CREATED_ON) != null
		? resultSet.getTimestamp(RoomOverviewDaoImpl.CREATED_ON).toInstant()
		: null);
	roomOverviewItemDto.setId(resultSet.getInt(RoomOverviewDaoImpl.ID));
	roomOverviewItemDto.setItemName(resultSet.getString(RoomOverviewDaoImpl.ITEM_NAME));
	roomOverviewItemDto.setRoomId(resultSet.getInt(RoomOverviewDaoImpl.ROOM_ID));
	roomOverviewItemDto.setSubItemName(resultSet.getString(RoomOverviewDaoImpl.SUBITEM_NAME));
	Array subItemArray = resultSet.getArray(RoomOverviewDaoImpl.SUBITEMS);
	String[] strArray = subItemArray == null ? null : (String[]) subItemArray.getArray();
	roomOverviewItemDto.setSubItems((strArray == null) ? null : new ArrayList<>(Arrays.asList(strArray)));

	return roomOverviewItemDto;
    }

}
