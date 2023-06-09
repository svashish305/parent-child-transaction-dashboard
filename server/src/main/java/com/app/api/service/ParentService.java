package com.app.api.service;

import org.springframework.data.domain.Page;

import com.app.api.model.Parent;

public interface ParentService {

	public Page<Parent> getPaginatedParents(int page, int size, String sortBy, int sortOrder);
}
