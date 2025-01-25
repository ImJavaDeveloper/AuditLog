package com.audit.log.service;

import com.audit.log.entity.AuditLog;
import com.audit.log.repository.AuditLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class AuditServiceImpl implements AuditService{
    @Autowired
    AuditLogRepository auditLogRepository;

    @Override
    public void saveAuditData(String tableName, String action, String newValue, String oldValue) {
        log.info("Saving data into auditLog:{}",tableName);
        AuditLog auditLog=new AuditLog();
        auditLog.setTableName(tableName);
        auditLog.setAction(action);
        auditLog.setOldValue(oldValue);
        auditLog.setNewValue(newValue);
        auditLog.setChangeBy("System");
        auditLog.setCreationOrUpdateTime(LocalDateTime.now());
        log.info(auditLog.toString());
        auditLogRepository.save(auditLog);

    }
}
