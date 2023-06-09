package com.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.model.ChildDTO;
import com.app.api.service.ChildService;

@RestController
public class ChildController {

  @Autowired
  ChildService childService;

  @GetMapping(path = "/child")
  public ResponseEntity<List<ChildDTO>> getChildrenByParentId(
      @RequestParam(value = "parentId", defaultValue = "1") Long parentId) {
    return ResponseEntity.ok(childService.getChildrenByParentId(parentId));
  }
}
