package com.zekiosun.blogs.controller;

import com.zekiosun.blogs.pojo.User;
import com.zekiosun.blogs.service.UserService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public Result<User> LoginConfirm(@RequestBody Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");
        List<User> users =userService.findByUsername(username);
        if(users.isEmpty()){
            return new Result<User>(true,20003,"No User Found");
        }
        if(!users.get(0).getPassword().equals(password)){
            return new Result<User>(true,20003,"Wrong Password");
        }
        return new Result<User>(true,20000,"Access Successfully",users);
    }
}
