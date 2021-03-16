package com.hotel.app.enquiry.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.app.enquiry.dao.EnquiryDao;
import com.hotel.app.enquiry.dto.EnquiryDto;

@Service
@Transactional(readOnly = true)
public class EnquiryServiceImpl implements EnquiryService {

	private EnquiryDao enquiryDao;
	
	public EnquiryServiceImpl(EnquiryDao enquiryDao) {
		this.enquiryDao = enquiryDao;
	}
	
	@Override
	@Transactional(readOnly = false)
	public EnquiryDto createEnquiry(EnquiryDto enquiryDto) {
		enquiryDao.addEnquiry(enquiryDto);
		return enquiryDto;
	}

	@Override
	public List<EnquiryDto> getEnquiry() {
		return enquiryDao.findEnquiry();
	}
}
