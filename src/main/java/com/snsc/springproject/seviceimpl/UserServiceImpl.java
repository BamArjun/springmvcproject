package com.snsc.springproject.seviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snsc.springproject.model.User;
import com.snsc.springproject.repository.UserRepository;
import com.snsc.springproject.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
private UserRepository userRepo;
	@Override
	public void userSignup(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public User userLogin(String un, String pw) {
		// TODO Auto-generated method stub
		return userRepo.findByUsernameAndPassword(un, pw);
	}

	@Override
	public User isUserExist(String un) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(un);
	}

}
