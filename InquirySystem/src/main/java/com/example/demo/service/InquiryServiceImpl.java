package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.InquiryNotFoundException;
import com.example.demo.model.Inquiry;
import com.example.demo.model.InquiryStatus;
import com.example.demo.repository.InquiryRepository;

@Service
public class InquiryServiceImpl implements InquiryService {
	@Autowired
	private InquiryRepository inquiryRepository;

	public Inquiry createInquiry(Inquiry inquiry) {
		inquiry.setStatus(InquiryStatus.NEW);
		return inquiryRepository.save(inquiry);
	}

	public Inquiry updateStatus(int inquiryId, InquiryStatus status) throws InquiryNotFoundException {
	    List<Inquiry> inquiries = inquiryRepository.findByUserId(inquiryId);

	    if (inquiries.isEmpty()) {
	        throw new InquiryNotFoundException("No inquiry found for ID: " + inquiryId);
	    }
	    Inquiry inquiryToUpdate = inquiries.stream()
	        .filter(inquiry -> inquiry.getInquiryId() == inquiryId)
	        .findFirst()
	        .orElseThrow(() -> new InquiryNotFoundException("Inquiry with ID " + inquiryId + " not found"));

	    inquiryToUpdate.setStatus(status);
	    return inquiryRepository.save(inquiryToUpdate);
	}



	
}
