package com.hotel.app.enquiry.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hotel.app.enquiry.dto.EnquiryDto;
import com.hotel.app.enquiry.dto.EnquiryStatus;

@Component
public class EnquiryMapper implements RowMapper<EnquiryDto> {

	@Override
	public EnquiryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EnquiryDto enquiryDto = new EnquiryDto();
		enquiryDto.setId(rs.getInt(EnquiryDaoImpl.ID));
		enquiryDto.setFirstName(rs.getString(EnquiryDaoImpl.FIRST_NAME));
		enquiryDto.setLastName(rs.getString(EnquiryDaoImpl.LAST_NAME));
		enquiryDto.setContactNo(rs.getString(EnquiryDaoImpl.CONTACT_NO));
		enquiryDto.setGuestCount(rs.getInt(EnquiryDaoImpl.GUEST_COUNT));
		enquiryDto.setCheckInDate(rs.getDate(EnquiryDaoImpl.CHECKIN_DATE) != null
				? rs.getDate(EnquiryDaoImpl.CHECKIN_DATE).toLocalDate() : null);
		enquiryDto.setCheckOutDate(rs.getDate(EnquiryDaoImpl.CHECKOUT_DATE) != null
				? rs.getDate(EnquiryDaoImpl.CHECKOUT_DATE).toLocalDate() : null);
		enquiryDto.setCustomerComment(rs.getString(EnquiryDaoImpl.CUSTOMER_COMMENT));
		enquiryDto.setOwnerComment(rs.getString(EnquiryDaoImpl.OWNER_COMMENT));
		enquiryDto.setEnquiryStatus(EnquiryStatus.valueOf(rs.getString(EnquiryDaoImpl.ENQUIRY_STATUS)));
		enquiryDto.setCreatedOn(rs.getTimestamp(EnquiryDaoImpl.CREATED_ON) != null
				? rs.getTimestamp(EnquiryDaoImpl.CREATED_ON).toInstant() : null);

		return enquiryDto;
	}
}
