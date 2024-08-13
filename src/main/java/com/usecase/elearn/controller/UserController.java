package com.usecase.elearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.elearn.model.User;
import com.usecase.elearn.service.UserService;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService us;

    @PostMapping("/adduser")
    public User adduser(@RequestBody User user) {
        return us.save(user);
    }

    @GetMapping("/courses/{userId}")
    public ResponseEntity<List<String>> getCoursesByUserId(@PathVariable long userId) {
        List<String> courseNames = us.getCourseNamesByUserId(userId);
        return ResponseEntity.ok(courseNames);
    }

}
