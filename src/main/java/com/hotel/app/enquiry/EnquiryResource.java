package com.hotel.app.enquiry;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hotel.app.enquiry.dto.EnquiryDto;
import com.hotel.app.enquiry.service.EnquiryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Enquiry Resource API")
@RestController
@RequestMapping("/api")
public class EnquiryResource {

	private EnquiryService enquiryService;

	public EnquiryResource(EnquiryService enquiryService) {
		this.enquiryService = enquiryService;
	}

	@ApiOperation(value = "Create customer enquiry", notes = "Enquiry data")
	@PostMapping(path = "/enquiry", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EnquiryDto> createEnquiry(@RequestBody EnquiryDto enquiryDto) {
		EnquiryDto enquiry = this.enquiryService.createEnquiry(enquiryDto);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri()).body(enquiry);
	}

	@ApiOperation(value = "Get all customer enquiries", notes = "All Enquiry data")
	@GetMapping(path = "/enquiry", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EnquiryDto>> getEnquiry() {
		List<EnquiryDto> enquiries = this.enquiryService.getEnquiry();
		return ResponseEntity.ok(enquiries);
	}
}
