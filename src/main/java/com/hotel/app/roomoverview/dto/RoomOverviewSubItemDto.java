package com.hotel.app.roomoverview.dto;

import java.util.List;

public class RoomOverviewSubItemDto {
    private String subItemName;
    private List<String> subItems;

    public RoomOverviewSubItemDto() {
    }

    public RoomOverviewSubItemDto(String subItemName, List<String> subItems) {
	this.subItemName = subItemName;
	this.subItems = subItems;
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

}
