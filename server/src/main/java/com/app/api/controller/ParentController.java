package com.app.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.exceptions.CustomException;
import com.app.api.model.ErrorResponse;
import com.app.api.service.ParentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class ParentController {

	@Autowired
	ParentService parentService;

	/**
	 * Gets a paginated list of parents.
	 *
	 * @param page      The page number, required, defaults to 0 which corresponds
	 *                  to the first page.
	 * @param size      The size of the page, optional, defaults to 2.
	 * @param sortBy    The field to sort by, optional, defaults to id.
	 * @param sortOrder The sort order, optional, defaults to ASC.
	 * @return A ResponseEntity containing a Page of Parents.
	 */
	@GetMapping(path = "/parent")
	public ResponseEntity<?> getParents(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "2") int size,
			@RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
			@RequestParam(value = "sortOrder", defaultValue = "1") int sortOrder) {
		try {
			return ResponseEntity.ok(parentService.getPaginatedParents(page, size, sortBy, sortOrder));
		} catch (CustomException e) {
			ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
		}
	}
}
