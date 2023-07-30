package com.example.demo.DAO_REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.MODEL_ENTITY.UserToken;

public interface IUserTokenDAO extends JpaRepository<UserToken, Long> {
	

}
