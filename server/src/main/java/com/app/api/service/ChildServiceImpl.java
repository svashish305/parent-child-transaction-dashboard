package com.app.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.api.model.ChildDTO;
import com.app.api.repositories.ChildRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ChildServiceImpl implements ChildService {
    @Autowired
    ChildRepository childRepository;

    @Override
    public List<ChildDTO> getChildrenByParentId(Long parentId) {
        // Check if the parentId is null
        if (parentId == null) {
            throw new IllegalArgumentException("parentId cannot be null");
        }

        return childRepository.getChildrenByParentId(parentId)
                .stream()
                .map(child -> {
                    ChildDTO childDTO = new ChildDTO();
                    childDTO.setId((Long) child[0]);
                    childDTO.setSender((String) child[1]);
                    childDTO.setReceiver((String) child[2]);
                    childDTO.setTotalAmount((Long) child[3]);
                    childDTO.setPaidAmount((Long) child[4]);
                    return childDTO;
                })
                .collect(Collectors.toList());
    }

}
