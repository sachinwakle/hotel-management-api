package com.hotel.app.room.dto;

import java.time.Instant;
import java.util.List;

import com.hotel.app.roomoverview.dto.RoomOverviewDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Room")
public class RoomDto {
    @ApiModelProperty(value = "Id")
    private Integer id;
    
    @ApiModelProperty(value = "Title")
    private String title;

    @ApiModelProperty(value = "Subtitle")
    private String subtitle;

    @ApiModelProperty(value = "Description")
    private String description;

    @ApiModelProperty(value = "Room Rate")
    private Integer roomRate;

    @ApiModelProperty(value = "Room Rate Offer Name")
    private String roomRateOfferName;

    @ApiModelProperty(value = "Room Rate Discount Percentage")
    private Float roomRateDiscountPercentage;

    @ApiModelProperty(value = "Created On")
    private Instant createdOn;

    @ApiModelProperty(value = "Room Rate After Discount")
    private Integer roomRateAfterDiscount;

    @ApiModelProperty(value = "List of Rooms Items")
    private List<RoomOverviewDto> roomOverview;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getSubtitle() {
	return subtitle;
    }

    public void setSubtitle(String subtitle) {
	this.subtitle = subtitle;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Integer getRoomRate() {
	return roomRate;
    }

    public void setRoomRate(Integer roomRate) {
	this.roomRate = roomRate;
    }

    public String getRoomRateOfferName() {
	return roomRateOfferName;
    }

    public void setRoomRateOfferName(String roomRateOfferName) {
	this.roomRateOfferName = roomRateOfferName;
    }

    public Float getRoomRateDiscountPercentage() {
	return roomRateDiscountPercentage;
    }

    public void setRoomRateDiscountPercentage(Float roomRateDiscountPercentage) {
	this.roomRateDiscountPercentage = roomRateDiscountPercentage;
    }

    public Instant getCreatedOn() {
	return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
	this.createdOn = createdOn;
    }

    public Integer getRoomRateAfterDiscount() {
	return roomRateAfterDiscount;
    }

    public void setRoomRateAfterDiscount(Integer roomRateAfterDiscount) {
	this.roomRateAfterDiscount = roomRateAfterDiscount;
    }

    public List<RoomOverviewDto> getRoomOverview() {
	return roomOverview;
    }

    public void setRoomOverview(List<RoomOverviewDto> roomOverview) {
	this.roomOverview = roomOverview;
    }

}
