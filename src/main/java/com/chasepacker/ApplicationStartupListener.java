package com.chasepacker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;

@Component
public class ApplicationStartupListener {

    @Autowired
    private DBManager dbManager;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        if (dbManager.checkPasswordEncoderInitialized()) {
            System.out.println("PasswordEncoder is initialized.");
        } else {
            System.out.println("PasswordEncoder is not initialized.");
        }
    }
}