package com.hotel.app.enquiry.dto;


import java.time.Instant;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Enquiry")
public class EnquiryDto {
    
	@ApiModelProperty(value = "Id")
    private Integer id;
    
    @ApiModelProperty(value = "First Name")
    private String firstName;

    @ApiModelProperty(value = "Last Name")
    private String lastName;

    @ApiModelProperty(value = "Contact Number")
    private String contactNo;

    @ApiModelProperty(value = "Guest Count")
    private Integer guestCount;

    @ApiModelProperty(value = "Check-In Date")
    private LocalDate checkInDate;
    
    @ApiModelProperty(value = "Check-Out Date")
    private LocalDate checkOutDate;

    @ApiModelProperty(value = "Customer Comment")
    private String customerComment;
    
    @ApiModelProperty(value = "Owner Comment")
    private String ownerComment;

    @ApiModelProperty(value = "Enquiry Status")
    private EnquiryStatus enquiryStatus;

    @ApiModelProperty(value = "Created On")
    private Instant createdOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Integer getGuestCount() {
		return guestCount;
	}

	public void setGuestCount(Integer guestCount) {
		this.guestCount = guestCount;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getCustomerComment() {
		return customerComment;
	}

	public void setCustomerComment(String customerComment) {
		this.customerComment = customerComment;
	}

	public String getOwnerComment() {
		return ownerComment;
	}

	public void setOwnerComment(String ownerComment) {
		this.ownerComment = ownerComment;
	}

	public EnquiryStatus getEnquiryStatus() {
		return enquiryStatus;
	}

	public void setEnquiryStatus(EnquiryStatus enquiryStatus) {
		this.enquiryStatus = enquiryStatus;
	}

	public Instant getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}
}
