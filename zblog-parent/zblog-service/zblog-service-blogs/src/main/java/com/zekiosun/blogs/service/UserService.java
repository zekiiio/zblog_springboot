package com.zekiosun.blogs.service;

import com.zekiosun.blogs.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findByUsername(String username);

}
