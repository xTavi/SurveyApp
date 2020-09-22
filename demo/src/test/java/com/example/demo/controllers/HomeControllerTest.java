package com.example.demo.controllers;

import org.junit.jupiter.api.BeforeEach;
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
        //
        assertEquals("<h1>Welcome</h1>",
                homeController.home(null),
                "When the user is not logged in");

        Principal principal = () -> "Admin";
        assertEquals("<h1>Welcome Admin " + principal.getName() + "</h1>",
                homeController.home(principal),
                "When the user is logged is as an admin");

        //
    }

    @Test
    void user() {
    }

    @Test
    void admin() {
    }
}