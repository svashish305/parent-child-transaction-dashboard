package com.app.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.app.api.model.Parent;
import com.app.api.repositories.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    ParentRepository parentRepository;

    @Override
    public Page<Parent> getPaginatedParents(int page, int size, String sortBy, int sortOrder) {
        Direction sortingOrder = sortOrder == 1 ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(sortingOrder, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return parentRepository.findAll(pageRequest);
    }

}
