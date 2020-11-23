package com.zekiosun.blogs.service.impl;

import com.zekiosun.blogs.dao.UserMapper;
import com.zekiosun.blogs.pojo.User;
import com.zekiosun.blogs.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    //自定义搜索对象Example
    public Example createExampleByUsername(String username){
        Example example = new Example(User.class);
        //条件构造器
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("username",username);
        return example;
    }

    @Override
    public List<User> findByUsername(String username) {
        Example example = createExampleByUsername(username);
        return userMapper.selectByExample(example);
    }
}
