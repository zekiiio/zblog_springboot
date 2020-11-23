package com.zekiosun.blogs.controller;

import com.zekiosun.blogs.pojo.Blog;
import com.zekiosun.blogs.service.BlogService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/blogs")
@CrossOrigin
public class BlogsController {

    @Resource
    private BlogService blogService;

    @GetMapping
    public Result<List<Blog>> findAll(){
        List<Blog> blogs = blogService.findAll();
        return new Result<List<Blog>>(true, StatusCode.OK, "查询所有Blog成功",blogs);
    }
}
