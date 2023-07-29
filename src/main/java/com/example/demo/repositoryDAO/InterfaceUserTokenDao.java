package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelEntity.UserToken;

public interface InterfaceUserTokenDao extends JpaRepository<UserToken, Long> {
	

}
