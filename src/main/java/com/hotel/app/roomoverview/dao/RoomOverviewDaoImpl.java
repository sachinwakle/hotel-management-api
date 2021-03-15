package com.hotel.app.roomoverview.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.app.common.dto.QueryParamDto;
import com.hotel.app.roomoverview.dto.RoomOverviewItemDto;

@Repository
@Transactional(readOnly = true)
public class RoomOverviewDaoImpl implements RoomOverviewDao {

    private static final Logger log = LoggerFactory.getLogger(RoomOverviewDaoImpl.class);

    protected static final String ID = "id";
    protected static final String ROOM_ID = "roomId";
    protected static final String ITEM_NAME = "itemName";
    protected static final String SUBITEM_NAME = "subItemName";
    protected static final String SUBITEMS = "subItems";
    protected static final String CREATED_ON = "createdOn";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final RoomOverviewMapper roomOverviewMapper;

    public RoomOverviewDaoImpl(DataSource dataSource, RoomOverviewMapper roomOverviewMapper) {
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
	this.roomOverviewMapper = roomOverviewMapper;
    }
    
    @Override
    public List<RoomOverviewItemDto> findRoomOverview() {
	QueryParamDto query = new QueryParamDto().withQuery(String.join(" ", "SELECT ro.id as", ID, ", ro.room_id as",
		ROOM_ID, ", ro.item_name as", ITEM_NAME, ", ro.sub_item_name as", SUBITEM_NAME, ", ro.sub_items as",
		SUBITEMS, ", ro.created_on as", CREATED_ON, "FROM room_overview ro"));

	log.debug("RoomOverview Query: {}", query.getQuery());

	return this.namedParameterJdbcTemplate.query(query.getQuery(), this.roomOverviewMapper);
    }

}
