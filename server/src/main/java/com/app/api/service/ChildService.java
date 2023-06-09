package com.app.api.service;

import java.util.List;

import com.app.api.model.ChildDTO;

public interface ChildService {
	public List<ChildDTO> getChildrenByParentId(Long parentId);
}
