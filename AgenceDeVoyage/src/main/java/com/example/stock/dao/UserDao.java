package com.example.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.User;
@Repository
public interface UserDao extends JpaRepository<User, Long> {
	User findByLogin(String login);
    User findByFirstNameAndLasNameAndLogin(String prenom,String nom,String email);
}
