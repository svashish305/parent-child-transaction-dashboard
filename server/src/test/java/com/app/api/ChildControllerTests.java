package com.app.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.api.controller.ChildController;

public class ChildControllerTests {
    @Autowired
    private ChildController childController;

    @Test
    public void testGetChildrenByParentId() {
        ResponseEntity<?> response = childController.getChildrenByParentId(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetChildrenByParentId_NoParentId() {
        ResponseEntity<?> response = childController.getChildrenByParentId(null);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
