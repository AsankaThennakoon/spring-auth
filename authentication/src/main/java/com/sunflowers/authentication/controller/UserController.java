package com.sunflowers.authentication.controller;

import com.sunflowers.authentication.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/welcome")
public class UserController {


    @GetMapping("/hi")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello hi ");
    }
}
