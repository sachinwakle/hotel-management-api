package com.hotel.app.room;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.app.room.dto.RoomDto;
import com.hotel.app.room.service.RoomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Room Resource API")
@RestController
@RequestMapping("/api")
public class RoomResource {

    private RoomService roomService;

    public RoomResource(RoomService roomService) {
	this.roomService = roomService;
    }

    @ApiOperation(value = "Get All Rooms Data", notes = "rooms data")
    @GetMapping(path = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoomDto>> getRooms() {
	List<RoomDto> rooms = this.roomService.findRooms();
	return ResponseEntity.ok(rooms);
    }
}
