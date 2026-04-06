package com.kidzapps.controller;

import com.kidzapps.dto.SubscriberRequest;
import com.kidzapps.entity.Subscriber;
import com.kidzapps.service.SubscriberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscribers")
@CrossOrigin(origins = "*")
public class SubscriberController {

    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @PostMapping
    public ResponseEntity<Subscriber> createSubscriber(@Valid @RequestBody SubscriberRequest request) {
        Subscriber savedSubscriber = subscriberService.createSubscriber(request);
        return new ResponseEntity<>(savedSubscriber, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Subscriber>> getAllSubscribers() {
        return ResponseEntity.ok(subscriberService.getAllSubscribers());
    }
}
