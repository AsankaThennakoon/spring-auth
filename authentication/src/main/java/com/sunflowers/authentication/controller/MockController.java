package com.sunflowers.authentication.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    // Endpoint for Manager role
    @GetMapping("/api/manager/test")
    @Secured("ROLE_MANAGER")
    public String managerAccess() {
        return "Hello, Manager! You have access to this endpoint.";
    }

    // Endpoint for Admin or Manager role
    @GetMapping("/api/employee/test")
    @Secured({"ROLE_MANAGER", "ROLE_ADMIN","ROLE_EMPLOYEE"})
    public String employeeAccess() {
        return "Hello, Admin or Manager! You have access to this endpoint.";
    }

    // Endpoint for Admin role only
    @GetMapping("/api/admin/test")
    @Secured("ROLE_ADMIN")
    public String adminAccess() {
        return "Hello, Admin! You have access to this endpoint.";
    }

    // Public endpoint
    @GetMapping("/api/public/test")
    public String publicAccess() {
        return "Hello, Public! This endpoint is open to everyone.";
    }
}
