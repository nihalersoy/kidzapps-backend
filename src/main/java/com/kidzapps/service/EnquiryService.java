package com.kidzapps.service;

import com.kidzapps.dto.EnquiryRequest;
import com.kidzapps.repository.EnquiryRepository;
import org.springframework.stereotype.Service;
import com.kidzapps.entity.Enquiry;

import java.util.List;

@Service
public class EnquiryService {
    private final EnquiryRepository enquiryRepository;

    public EnquiryService(EnquiryRepository enquiryRepository) {
        this.enquiryRepository = enquiryRepository;
    }

    public Enquiry createEnquiry(EnquiryRequest request) {
        Enquiry enquiry = new Enquiry();
        enquiry.setFullName(request.getFullName());
        enquiry.setEmail(request.getEmail());
        enquiry.setSubject(request.getSubject());
        enquiry.setMessage(request.getMessage());

        return enquiryRepository.save(enquiry);
    }

    public List<Enquiry> getAllEnquiries() {
        return enquiryRepository.findAll();
    }
}
