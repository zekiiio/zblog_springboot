package com.zekiosun.blogs.controller;

import com.github.pagehelper.PageInfo;
import com.zekiosun.blogs.pojo.Blog;
import com.zekiosun.blogs.service.BlogService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/blogs")
@CrossOrigin
public class BlogsController {

    @Resource
    private BlogService blogService;

/*    @GetMapping
    public Result<List<Blog>> findAll(){
        List<Blog> blogs = blogService.findAll();
        return new Result<List<Blog>>(true, StatusCode.OK, "查询所有成功",blogs);
    }*/

    @GetMapping
    public Result<PageInfo<Blog>> findPage(@RequestParam(value = "query", required = false) String query,
                                           @RequestParam(value = "pagenum") Integer pagenum,
                                           @RequestParam(value = "pagesize") Integer pagesize){
        if(query == null){
            PageInfo<Blog> pages = blogService.findPage(pagenum,pagesize);
            return new Result<PageInfo<Blog>>(true, StatusCode.OK, "分页查询成功",pages);
        }
        PageInfo<Blog> pages = blogService.findPage(query, pagenum, pagesize);
        return new Result<PageInfo<Blog>>(true, StatusCode.OK, "分页查询成功", pages);
    }

}
