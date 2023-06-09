package com.app.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.api.model.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {

}
