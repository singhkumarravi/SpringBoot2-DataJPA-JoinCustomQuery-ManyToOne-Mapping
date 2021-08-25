package com.olive.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olive.model.Deparment;

public interface DeptRepositiory extends JpaRepository<Deparment, Integer> {

}
