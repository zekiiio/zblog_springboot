package com.zekiosun.blogs.service;

import com.github.pagehelper.PageInfo;
import com.zekiosun.blogs.pojo.Blog;

import java.util.List;

public interface BlogService {

    /**
     * 查询所有
     * @return
     */
    List<Blog> findAll();

    /**
     * 条件+分页查询
     * @param query
     * @param page
     * @param size
     * @return
     */
    PageInfo<Blog> findPage(String query, Integer page, Integer size);
}
