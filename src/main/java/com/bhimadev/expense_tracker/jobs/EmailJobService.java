package com.bhimadev.expense_tracker.jobs;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailJobService {

    @Async
    public void sendWelcomeEmail(String email) {

        System.out.println("Email sending started for: " + email);

        try {
            Thread.sleep(5000); // simulate email delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Welcome email sent to: " + email);
    }
}