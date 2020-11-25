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
     * @param pagenum
     * @param pagesize
     * @return
     */
    PageInfo<Blog> findPage(String query, Integer pagenum, Integer pagesize);

    /**
     * 分页查询
     * @param pagenum
     * @param pagesize
     * @return
     */
    PageInfo<Blog> findPage(Integer pagenum, Integer pagesize);

    /**
     * 添加一条记录，并返回id
     * @param blog
     * @return
     */
    Long add(Blog blog);

    /**
     * 根据id删除一条记录
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据id查找一条记录
     * @param id
     * @return
     */
    Blog findById(Long id);

    void update(Blog blog);
}
