package com.app.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.model.Parent;
import com.app.api.service.ParentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@RestController
public class ParentController {

    @Autowired
    ParentService parentService;

    @GetMapping(path = "/parent")
    public ResponseEntity<Page<Parent>> getParents(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "2") int size,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "sortOrder", defaultValue = "1") int sortOrder) {
        return ResponseEntity.ok(parentService.getPaginatedParents(page, size, sortBy, sortOrder));
    }
}
