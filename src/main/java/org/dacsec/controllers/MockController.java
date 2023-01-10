package org.dacsec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mocks")
public class MockController {

    @Autowired
    private MockService mockService;

    @GetMapping
    public List<Mock> findAllMocks() {
        return mockService.findAllMocks();
    }
}
