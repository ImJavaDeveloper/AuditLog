package com.audit.log.controller;

import com.audit.log.entity.User;
import com.audit.log.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

   @Autowired
   UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.ACCEPTED);
    }

    @PutMapping("/user/update")
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/user/{username}")
    public ResponseEntity<User> deleteUser(@PathVariable String username)
    {
        userService.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
