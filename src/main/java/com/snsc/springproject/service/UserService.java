package com.snsc.springproject.service;

import com.snsc.springproject.model.User;

public interface UserService {
void userSignup(User user);
User userLogin(String un,String pw);
User isUserExist (String un);
}
