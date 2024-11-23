package com.javaguides.banking_app.exception;

import java.time.LocalDateTime;

public record ErrorDetails(String message, String description, LocalDateTime timestamp) {
    // Canonical Constructor
    public ErrorDetails {
        if(timestamp == null) {
            timestamp = LocalDateTime.now();
        }
    }
}
