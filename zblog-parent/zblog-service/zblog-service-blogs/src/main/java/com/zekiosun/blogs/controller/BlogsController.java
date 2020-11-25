package com.zekiosun.blogs.controller;

import com.github.pagehelper.PageInfo;
import com.zekiosun.blogs.pojo.Blog;
import com.zekiosun.blogs.pojo.BlogContent;
import com.zekiosun.blogs.service.BlogContentService;
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

    @Resource
    private BlogContentService blogContentService;

/*    @GetMapping
    public Result<List<Blog>> findAll(){
        List<Blog> blogs = blogService.findAll();
        return new Result<List<Blog>>(true, StatusCode.OK, "查询所有成功",blogs);
    }*/

    @GetMapping
    public Result<PageInfo<Blog>> findPageInfo(@RequestParam(value = "query", required = false) String query,
                                           @RequestParam(value = "pagenum") Integer pagenum,
                                           @RequestParam(value = "pagesize") Integer pagesize){
        if(query == null){
            PageInfo<Blog> pages = blogService.findPage(pagenum,pagesize);
            return new Result<PageInfo<Blog>>(true, StatusCode.OK, "分页查询成功",pages);
        }
        PageInfo<Blog> pages = blogService.findPage(query, pagenum, pagesize);
        return new Result<PageInfo<Blog>>(true, StatusCode.OK, "分页查询成功", pages);
    }

    @PostMapping
    public Result add(@RequestBody Blog blog){
        Long addId = blogService.add(blog);
        blogContentService.add(addId, blog.getTitle());
        return new Result(true, StatusCode.OK, "Add one Blog Successfully");
    }

    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable(value = "id") Long id){
        blogService.deleteById(id);
        blogContentService.deleteById(id);
        return new Result(true, StatusCode.OK, "Delete one Blog Successfully");
    }
    
    @GetMapping(value = "/{id}")
    public Result<Blog> findInfoById(@PathVariable(value = "id") Long id){
        Blog blog = blogService.findById(id);
        return new Result<Blog>(true,StatusCode.OK,"One Blog Found",blog);
    }

    @GetMapping(value = "/blog/{id}")
    public Result<BlogContent> findContentById(@PathVariable(value = "id") Long id){
        BlogContent blogContent = blogContentService.findById(id);
        return new Result<BlogContent>(true,StatusCode.OK,"Blog Content Found",blogContent);
    }

    @PostMapping(value = "/blog/{id}")
    public Result updateById(@PathVariable(value = "id") Long id,
                             @RequestBody BlogContent blogContent){
        blogContent.setId(id);
        blogContentService.update(blogContent);
        Blog blog = blogService.findById(id);
        blog.setTitle(blogContent.getTitle());
        blogService.update(blog);
        return new Result(true,StatusCode.OK,"Blog Update Successfully");
    }
}
