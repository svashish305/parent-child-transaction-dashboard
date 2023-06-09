package com.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.exceptions.CustomException;
import com.app.api.model.ErrorResponse;
import com.app.api.service.ChildService;

@RestController
public class ChildController {

  @Autowired
  ChildService childService;

  /**
   * Gets a list of children by parent ID.
   *
   * @param parentId The ID of the parent.
   * @return A ResponseEntity containing a List of ChildDTOs corresponding to
   *         given parentId.
   */
  @GetMapping(path = "/child")
  public ResponseEntity<?> getChildrenByParentId(
      @RequestParam(value = "parentId", defaultValue = "1") Long parentId) {
    try {
      return ResponseEntity.ok(childService.getChildrenByParentId(parentId));
    } catch (CustomException e) {
      ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
      return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }
  }
}
