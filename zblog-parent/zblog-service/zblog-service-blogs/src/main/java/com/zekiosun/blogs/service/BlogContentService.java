package com.zekiosun.blogs.service;

import com.zekiosun.blogs.pojo.BlogContent;

public interface BlogContentService {

    public BlogContent findById(Long id);

    void add(Long id, String title);

    void update(BlogContent blogContent);

    void deleteById(Long id);

}
