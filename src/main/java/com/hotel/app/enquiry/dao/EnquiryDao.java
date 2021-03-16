package com.hotel.app.enquiry.dao;

import java.util.List;

import com.hotel.app.enquiry.dto.EnquiryDto;

public interface EnquiryDao {

	public int addEnquiry(EnquiryDto enquiryDto);

	public List<EnquiryDto> findEnquiry(); 
}
