package com.audit.log.service;

public interface AuditService {

    void saveAuditData(String tableName, String action,String newValue,String oldValue);
}
