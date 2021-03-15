package com.hotel.app.room.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.app.common.dto.QueryParamDto;
import com.hotel.app.room.dto.RoomDto;

@Repository
@Transactional(readOnly = true)
public class RoomDaoImpl implements RoomDao {
    private static final Logger log = LoggerFactory.getLogger(RoomDaoImpl.class);

    protected static final String ID = "id";
    protected static final String TITLE = "title";
    protected static final String SUBTITLE = "subtitle";
    protected static final String DESCRIPTION = "description";
    protected static final String ROOM_RATE = "roomRate";
    protected static final String ROOM_RATE_OFFER_NAME = "roomRateOfferName";
    protected static final String ROOM_RATE_DISCOUNT_PERCENTAGE = "roomRateDiscountPercentage";
    protected static final String CREATED_ON = "createdOn";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final RoomMapper roomMapper;

    public RoomDaoImpl(DataSource dataSource, RoomMapper roomMapper) {
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
	this.roomMapper = roomMapper;
    }

    @Override
    public List<RoomDto> findRooms() {
	QueryParamDto query = new QueryParamDto().withQuery(String.join(" ", "SELECT room.id as", ID, ", room.title as",
		TITLE, ", room.subtitle as", SUBTITLE, ", room.description as", DESCRIPTION, ", room.room_rate as",
		ROOM_RATE, ", room.room_rate_offer_name as", ROOM_RATE_OFFER_NAME,
		", room.room_rate_discount_percentage as", ROOM_RATE_DISCOUNT_PERCENTAGE, ", room.created_on as",
		CREATED_ON, "FROM room"));

	log.debug("Find Rooms Query: {}", query.getQuery());

	return this.namedParameterJdbcTemplate.query(query.getQuery(), this.roomMapper);
    }

}
