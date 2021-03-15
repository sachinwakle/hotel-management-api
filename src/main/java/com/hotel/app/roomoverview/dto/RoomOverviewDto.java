package com.hotel.app.roomoverview.dto;

import java.time.Instant;
import java.util.List;

public class RoomOverviewDto {
    private Integer id;
    private Integer roomId;
    private String itemName;
    private List<RoomOverviewSubItemDto> items;
    private Instant createdOn;

    public RoomOverviewDto() {
    }

    public RoomOverviewDto(RoomOverviewItemDto roomOverviewItemDto, List<RoomOverviewSubItemDto> subItems) {
	this.setId(roomOverviewItemDto.getId());
	this.setCreatedOn(roomOverviewItemDto.getCreatedOn());
	this.setItemName(roomOverviewItemDto.getItemName());
	this.setRoomId(roomOverviewItemDto.getRoomId());
	this.setItems(subItems);
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getRoomId() {
	return roomId;
    }

    public void setRoomId(Integer roomId) {
	this.roomId = roomId;
    }

    public String getItemName() {
	return itemName;
    }

    public void setItemName(String itemName) {
	this.itemName = itemName;
    }

    public List<RoomOverviewSubItemDto> getItems() {
	return items;
    }

    public void setItems(List<RoomOverviewSubItemDto> items) {
	this.items = items;
    }

    public Instant getCreatedOn() {
	return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
	this.createdOn = createdOn;
    }

}
