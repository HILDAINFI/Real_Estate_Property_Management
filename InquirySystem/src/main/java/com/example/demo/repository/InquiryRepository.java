package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
    List<Inquiry> findByUserId(int userId);
}

