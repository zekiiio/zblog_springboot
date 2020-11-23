package com.zekiosun.blogs.service.impl;

import com.github.pagehelper.PageInfo;
import com.zekiosun.blogs.dao.BlogMapper;
import com.zekiosun.blogs.pojo.Blog;
import com.zekiosun.blogs.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = blogMapper.selectAll();
        return blogs;
    }

    @Override
    public PageInfo<Blog> findPage(String query, Integer page, Integer size) {
        return null;
    }
}
