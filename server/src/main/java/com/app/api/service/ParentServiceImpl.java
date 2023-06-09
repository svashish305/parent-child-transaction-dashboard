package com.app.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.api.exceptions.CustomException;
import com.app.api.model.Parent;
import com.app.api.repositories.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	ParentRepository parentRepository;

	@Override
	public Page<Parent> getPaginatedParents(int page, int size, String sortBy, int sortOrder) {
		if (page < 0) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "Page Number can not be negative!");
		}
		// Parse Sort order
		Direction sortingOrder = sortOrder == 1 ? Sort.Direction.ASC : Sort.Direction.DESC;
		// Create a Sort object
		Sort sort = Sort.by(sortingOrder, sortBy);
		// Create a PageRequest object
		PageRequest pageRequest = PageRequest.of(page, size, sort);
		// Return a Page of Parents
		return parentRepository.findAll(pageRequest);
	}

}
