package com.audit.log.service;

import com.audit.log.entity.User;

public interface UserService {

    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(String username);
}
