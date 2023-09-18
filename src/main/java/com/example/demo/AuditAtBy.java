package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditAtByListener.class)
public abstract class AuditAtBy implements Serializable {

    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
        createdBy = "User1";
        updatedBy = "User1";
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
        updatedBy = "User1";
    }
}
