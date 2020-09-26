package com.example.demo.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    HomeController homeController;

    @BeforeEach
    void setUp() {
        homeController = new HomeController();
    }


    @Test
    void home() {
        assertEquals("<h1>Welcome</h1>",
                homeController.home(null),
                "When the user is not logged in");

        Principal principal = () -> "Admin";
        assertEquals("<h1>Welcome Admin " + principal.getName() + "</h1>",
                homeController.home(principal),
                "When the user is logged is as an admin");
    }

    @Test
    @DisplayName("Testing for a normal user")
    void user() {
        assertEquals("<h1>Welcome User</h1>",
                homeController.user(),
                "When a normal user logs in");
    }

    @Test
    @DisplayName("When admin logs in")
    void admin() {
        Principal principal = () -> "Admin";

        assertEquals("<h1>Welcome Admin" + principal.getName() + "</h1>",
                homeController.admin(principal),
                "When admin logs in");
    }
}