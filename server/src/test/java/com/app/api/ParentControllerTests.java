package com.app.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.api.controller.ParentController;

public class ParentControllerTests {
    @Autowired
    private ParentController parentController;

    @Test
    public void testGetParents() {
        ResponseEntity<?> response = parentController.getParents(0, 2, "id", 1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
