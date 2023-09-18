package com.example.demo;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AuditAtByListener {
    @PrePersist
    public void onPrePersist(Object entity) {
        if (entity instanceof AuditAtBy) {
            ((AuditAtBy) entity).onCreate();
        }
    }

    @PreUpdate
    public void onPreUpdate(Object entity) {
        if (entity instanceof AuditAtBy) {
            ((AuditAtBy) entity).onUpdate();
        }
    }
}
