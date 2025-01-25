package com.audit.log.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "auditLog")
@Data
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long logId;
    private String tableName;
    private String action;
    private String oldValue;
    private String newValue;
    private String changeBy;
    private LocalDateTime creationOrUpdateTime;




}
