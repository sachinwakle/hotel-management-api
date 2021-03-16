package com.hotel.app.enquiry.service;

import java.util.List;

import com.hotel.app.enquiry.dto.EnquiryDto;

public interface EnquiryService {

    public EnquiryDto createEnquiry(EnquiryDto enquiryDto);

	public List<EnquiryDto> getEnquiry();
}

