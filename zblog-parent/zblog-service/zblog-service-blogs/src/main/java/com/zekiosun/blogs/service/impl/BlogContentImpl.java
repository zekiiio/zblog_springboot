package com.zekiosun.blogs.service.impl;

import com.zekiosun.blogs.dao.BlogContentMapper;
import com.zekiosun.blogs.pojo.BlogContent;
import com.zekiosun.blogs.service.BlogContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

@Service
public class BlogContentImpl implements BlogContentService {

    @Resource
    private BlogContentMapper blogContentMapper;

    @Override
    public BlogContent findById(Long id) {
        return blogContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Long id, String title) {
        BlogContent blogContent = new BlogContent();
        blogContent.setId(id);
        blogContent.setTitle(title);
        blogContent.setContent("");
        blogContentMapper.insert(blogContent);
    }

    @Override
    public void update(BlogContent blogContent) {
        blogContentMapper.updateByPrimaryKey(blogContent);
    }

    @Override
    public void deleteById(Long id) {
        blogContentMapper.deleteByPrimaryKey(id);
    }
}
