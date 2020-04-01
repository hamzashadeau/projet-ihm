package com.example.stock.Service.Facade;

import com.example.stock.Bean.User;

public interface UserService {
	User findByLogin(String login);
	int save(User user);
	User findByFirstNameAndLasNameAndLogin(String prenom,String nom,String email);
}
