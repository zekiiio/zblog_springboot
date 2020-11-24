package com.zekiosun.blogs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zekiosun.blogs.dao.BlogMapper;
import com.zekiosun.blogs.pojo.Blog;
import com.zekiosun.blogs.service.BlogService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    //自定义搜索对象Example
    public Example createExampleByTitle(String query){
        Example example = new Example(Blog.class);
        //条件构造器
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("title","%" + query + "%");
        return example;
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = blogMapper.selectAll();
        return blogs;
    }

    /**
     * 搜索+分页查询
     * @param query
     * @param pagenum
     * @param pagesize
     * @return
     */
    @Override
    public PageInfo<Blog> findPage(String query, Integer pagenum, Integer pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        Example example = createExampleByTitle(query);
        List<Blog> blogs = blogMapper.selectByExample(example);
        return new PageInfo<Blog>(blogs);
    }

    /**
     * 分页查询
     * @param pagenum
     * @param pagesize
     * @return
     */
    @Override
    public PageInfo<Blog> findPage(Integer pagenum, Integer pagesize) {
        //Mapper接口方式的调用PageHelper
        PageHelper.startPage(pagenum,pagesize);
        List<Blog> list = blogMapper.selectAll();
        return new PageInfo<Blog>(list);
    }

    @Override
    public void add(Blog blog) {
        if(blog.getCreate_time()==null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            blog.setCreate_time(df.format(new Date()));
        }
        blog.setIs_active(1);
        blogMapper.insert(blog);
    }

    @Override
    public void deleteById(Integer id) {
        blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Blog findById(Integer id) {
        return blogMapper.selectByPrimaryKey(id);
    }
}
