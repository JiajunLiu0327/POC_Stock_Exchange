package com.nasdaq.virtualstockexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasdaq.virtualstockexchange.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
