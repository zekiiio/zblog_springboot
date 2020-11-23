package com.zekiosun.blogs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description = "Blog", value = "Blog")
@Table(name = "tbl_blog")
public class Blog implements Serializable {
    @ApiModelProperty(value = "编号", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;//编号

    @ApiModelProperty(value = "作者", required = false)
    @Column(name = "author")
    private String author;//作者

    @ApiModelProperty(value = "标题", required = false)
    @Column(name = "title")
    private String title;//标题

    @ApiModelProperty(value = "主题", required = false)
    @Column(name = "theme")
    private String theme;//主题

    @ApiModelProperty(value = "创建时间", required = false)
    @Column(name = "create_time")
    private String create_time;//创建时间

    @ApiModelProperty(value = "修改时间", required = false)
    @Column(name = "modify_time")
    private String modify_time;//修改时间


    @ApiModelProperty(value = "可见", required = false)
    @Column(name = "is_active")
    private String is_active;//可见

    @ApiModelProperty(value = "文件地址", required = false)
    @Column(name = "location")
    private String location;//文件地址

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
