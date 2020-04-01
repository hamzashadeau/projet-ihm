package com.example.stock.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.User;
import com.example.stock.Service.Facade.UserService;
import com.example.stock.dao.UserDao;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;



	@Override
	public int save(User user) {
		userDao.save(user);
		return 1;
	}

	@Override
	public User findByFirstNameAndLasNameAndLogin(String prenom, String nom, String email) {
		return userDao.findByFirstNameAndLasNameAndLogin(prenom, nom, email);
	}

	@Override
	public User findByLogin(String login) {
		return userDao.findByLogin(login);
	}

		
}
