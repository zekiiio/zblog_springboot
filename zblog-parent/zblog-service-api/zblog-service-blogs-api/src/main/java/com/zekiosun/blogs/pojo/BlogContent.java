package com.zekiosun.blogs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description = "BlogContent", value = "BlogContent")
@Table(name = "tbl_blogcontent")
public class BlogContent implements Serializable {
    @ApiModelProperty(value = "编号", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;//编号

    @ApiModelProperty(value = "标题", required = false)
    @Column(name = "title")
    private String title;//标题

    @ApiModelProperty(value = "内容", required = false)
    @Column(name = "content")
    private String content;//内容

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
