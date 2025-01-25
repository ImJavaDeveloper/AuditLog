package com.audit.log.entity;

import com.audit.log.repository.AuditLogRepository;
import com.audit.log.service.AuditService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@Data
public class AuditListener {

    private final AuditService auditService;

    AuditListener(@Lazy AuditService auditService)
    {
        this.auditService=auditService;
    }
    @PrePersist
    public void afterSave(Object entity)
    {
       String tableName=entity.getClass().getSimpleName();
       String newValue=entity.toString();
       log.info("After Saving Data into Table:{} with data:{}",tableName,newValue);
       saveData(tableName,"INSERT",newValue,null);
    }
    @PostUpdate
    public void afterUpdate(Object entity)
    {
        String tableName=entity.getClass().getSimpleName();
        String newValue=entity.toString();
        log.info("After Updating Data into Table:{} with data:{}",tableName,newValue);
        saveData(tableName,"UPDATE",newValue,null);

    }

    @PostRemove
    public void afterRemove(Object entity)
    {
        String tableName=entity.getClass().getSimpleName();
        String newValue=entity.toString();
        log.info("After Deleting Data into Table:{}",entity.getClass().getSimpleName());
        saveData(tableName,"DELETE",newValue,null);

    }

    private void saveData(String tableName, String action,String newValue,String oldValue)
    {
        auditService.saveAuditData(tableName,action,newValue,oldValue);
    }

}
