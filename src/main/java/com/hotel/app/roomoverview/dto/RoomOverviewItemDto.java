package com.hotel.app.roomoverview.dto;

import java.time.Instant;
import java.util.List;

public class RoomOverviewItemDto {
    private Integer id;
    private Integer roomId;
    private String itemName;
    private String subItemName;
    private List<String> subItems;
    private Instant createdOn;

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

    public String getSubItemName() {
	return subItemName;
    }

    public void setSubItemName(String subItemName) {
	this.subItemName = subItemName;
    }

    public List<String> getSubItems() {
	return subItems;
    }

    public void setSubItems(List<String> subItems) {
	this.subItems = subItems;
    }

    public Instant getCreatedOn() {
	return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
	this.createdOn = createdOn;
    }

}
