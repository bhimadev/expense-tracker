package com.bhimadev.expense_tracker.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class JobScheduler {

    @Scheduled(cron = "0 * * * * ?")
    public void retryFailedJobs() {
        System.out.println("Retry every 1 min");
    }
}