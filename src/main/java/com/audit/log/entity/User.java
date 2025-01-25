package com.audit.log.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
@EntityListeners(AuditListener.class)
public class User {

    @Id
    private String username;

    private String password;
    private String firstName;
    private String lastName;


}
