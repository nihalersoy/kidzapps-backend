package com.kidzapps.service;

import com.kidzapps.dto.SubscriberRequest;
import com.kidzapps.entity.Subscriber;
import com.kidzapps.repository.SubscriberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService {

    private final SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public Subscriber createSubscriber(SubscriberRequest request) {
        subscriberRepository.findByEmail(request.getEmail())
                .ifPresent(subscriber -> {
                    throw new RuntimeException("This email is already subscribed.");
                });

        Subscriber subscriber = new Subscriber();
        subscriber.setEmail(request.getEmail());

        return subscriberRepository.save(subscriber);
    }

    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }
}