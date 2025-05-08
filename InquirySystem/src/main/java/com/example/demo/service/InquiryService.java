package com.example.demo.service;

import com.example.demo.exceptions.InquiryNotFoundException;
import com.example.demo.model.Inquiry;
import com.example.demo.model.InquiryStatus;

public interface InquiryService {
	public abstract Inquiry createInquiry(Inquiry inquiry);
	public abstract Inquiry updateStatus(int inquiryId, InquiryStatus status) throws InquiryNotFoundException;
}
