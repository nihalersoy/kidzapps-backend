package com.kidzapps.controller;

import com.kidzapps.dto.EnquiryRequest;
import com.kidzapps.entity.Enquiry;
import com.kidzapps.service.EnquiryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin(origins = "*")
public class EnquiryController {

    private final EnquiryService enquiryService;

    public EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }

    @PostMapping
    public ResponseEntity<Enquiry> createEnquiry(@Valid @RequestBody EnquiryRequest request) {
        Enquiry savedEnquiry = enquiryService.createEnquiry(request);
        return new ResponseEntity<>(savedEnquiry, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Enquiry>> getAllEnquiries() {
        return ResponseEntity.ok(enquiryService.getAllEnquiries());
    }
}
