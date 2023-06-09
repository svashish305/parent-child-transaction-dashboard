package com.app.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.api.model.Child;

public interface ChildRepository extends JpaRepository<Child, Long> {

	/*
	 * 
	 * Gets a list of children by parent ID.
	 * 
	 * @param parentId The ID of the parent.
	 * @return A list of children.
	 */
	@Query("SELECT c.id, c.parent.sender, c.parent.receiver, c.parent.totalAmount, c.paidAmount FROM Child c "
			+ "WHERE c.parent.id = :parentId")
	public List<Object[]> getChildrenByParentId(@Param("parentId") Long parentId);
}
