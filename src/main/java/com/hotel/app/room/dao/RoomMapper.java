package com.hotel.app.room.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hotel.app.room.dto.RoomDto;

@Component
public class RoomMapper implements RowMapper<RoomDto> {

    @Override
    public RoomDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	RoomDto roomDto = new RoomDto();
	roomDto.setId(resultSet.getInt(RoomDaoImpl.ID));
	roomDto.setCreatedOn(resultSet.getTimestamp(RoomDaoImpl.CREATED_ON) != null
		? resultSet.getTimestamp(RoomDaoImpl.CREATED_ON).toInstant()
		: null);
	roomDto.setDescription(resultSet.getString(RoomDaoImpl.DESCRIPTION));
	roomDto.setRoomRate(resultSet.getInt(RoomDaoImpl.ROOM_RATE));
	roomDto.setRoomRateDiscountPercentage(resultSet.getFloat(RoomDaoImpl.ROOM_RATE_DISCOUNT_PERCENTAGE));
	roomDto.setRoomRateOfferName(resultSet.getString(RoomDaoImpl.ROOM_RATE_OFFER_NAME));
	roomDto.setSubtitle(resultSet.getString(RoomDaoImpl.SUBTITLE));
	roomDto.setTitle(resultSet.getString(RoomDaoImpl.TITLE));
	return roomDto;
    }
}
