package com.hotel.app.enquiry.dao;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.app.common.dto.QueryParamDto;
import com.hotel.app.enquiry.dto.EnquiryDto;
import com.hotel.app.enquiry.dto.EnquiryStatus;

@Repository
@Transactional(readOnly = true)
public class EnquiryDaoImpl implements EnquiryDao {

	private static final Logger log = LoggerFactory.getLogger(EnquiryDaoImpl.class);

	protected static final String ID = "id";
	protected static final String FIRST_NAME = "firstName";
	protected static final String LAST_NAME = "lastName";
	protected static final String CONTACT_NO = "contactNo";
	protected static final String GUEST_COUNT = "guestCount";
	protected static final String CHECKIN_DATE = "checkInDate";
	protected static final String CHECKOUT_DATE = "checkOutDate";
	protected static final String CUSTOMER_COMMENT = "customerComment";
	protected static final String OWNER_COMMENT = "ownerComment";
	protected static final String ENQUIRY_STATUS = "enquiryStatus";
	protected static final String CREATED_ON = "createdOn";

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final EnquiryMapper enquiryMapper;

	public EnquiryDaoImpl(DataSource dataSource, EnquiryMapper enquiryMapper) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
		this.enquiryMapper = enquiryMapper;
	}

	@Override
	@Transactional(readOnly = false)
	public int addEnquiry(EnquiryDto enquiryDto) {
		QueryParamDto query = new QueryParamDto().withQuery(String.join(" ", "INSERT INTO ENQUIRY_DETAILS (",
				"first_name, last_name, contact_no, guest_count, checkin_date, checkout_date, customer_comment,",
				"owner_comment, enquiry_status, created_on) VALUES (",
				":" + FIRST_NAME + ", :" + LAST_NAME + ", :" + CONTACT_NO + ", :" + GUEST_COUNT + ", :" + CHECKIN_DATE
						+ ", :" + CHECKOUT_DATE + ", :" + CUSTOMER_COMMENT + ", :" + OWNER_COMMENT + ", :"
						+ ENQUIRY_STATUS + ", :" + CREATED_ON + ")"));
		query.addQueryParameter(FIRST_NAME, enquiryDto.getFirstName());
		query.addQueryParameter(LAST_NAME, enquiryDto.getLastName());
		query.addQueryParameter(CONTACT_NO, enquiryDto.getContactNo());
		query.addQueryParameter(GUEST_COUNT, enquiryDto.getGuestCount());
		query.addQueryParameter(CHECKIN_DATE, enquiryDto.getCheckInDate());
		query.addQueryParameter(CHECKOUT_DATE, enquiryDto.getCheckOutDate());
		query.addQueryParameter(CUSTOMER_COMMENT, enquiryDto.getCustomerComment());
		query.addQueryParameter(OWNER_COMMENT, enquiryDto.getOwnerComment());
		query.addQueryParameter(ENQUIRY_STATUS, EnquiryStatus.PENDING.toString());
		query.addQueryParameter(CREATED_ON, Timestamp.from(Instant.now()));

		log.debug("Create Enquiry Query: {}", query.getQuery());
		return namedParameterJdbcTemplate.update(query.getQuery(), query.getParameterSource());
	}

	@Override
	public List<EnquiryDto> findEnquiry() {
		QueryParamDto query = new QueryParamDto().withQuery(String.join(" ", "SELECT enquiry.id as", ID,
				", enquiry.first_name as", FIRST_NAME, ", enquiry.last_name as", LAST_NAME, ", enquiry.contact_no as",
				CONTACT_NO, ", enquiry.guest_count as", GUEST_COUNT, ", enquiry.checkin_date as", CHECKIN_DATE,
				", enquiry.checkout_date as", CHECKOUT_DATE, ", enquiry.customer_comment as", CUSTOMER_COMMENT,
				", enquiry.owner_comment as", OWNER_COMMENT, ", enquiry.enquiry_status as", ENQUIRY_STATUS,
				", enquiry.created_on as", CREATED_ON, "FROM enquiry_details enquiry"));

		log.debug("Find Enquiry Query: {}", query.getQuery());
		return namedParameterJdbcTemplate.query(query.getQuery(), enquiryMapper);
	}
}
