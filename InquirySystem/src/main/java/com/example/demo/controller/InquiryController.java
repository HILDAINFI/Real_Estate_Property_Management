package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.InquiryNotFoundException;
import com.example.demo.model.Inquiry;
import com.example.demo.model.InquiryStatus;
import com.example.demo.service.InquiryService;

@RestController
@RequestMapping("/inquiries")
public class InquiryController {
    @Autowired
    private InquiryService inquiryService;

    @PostMapping
    public ResponseEntity<Inquiry> createInquiry(@RequestBody Inquiry inquiry) {
        return ResponseEntity.ok(inquiryService.createInquiry(inquiry));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Inquiry> updateStatus(@PathVariable int id, @RequestParam InquiryStatus status) throws InquiryNotFoundException {
        return ResponseEntity.ok(inquiryService.updateStatus(id, status));
    }
}

