package com.zekiosun.blogs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description = "User", value = "User")
@Table(name = "tbl_user")
public class User implements Serializable {
    @ApiModelProperty(value = "编号", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;//编号

    @ApiModelProperty(value = "用户角色", required = false)
    @Column(name = "rid")
    private Long rid;//用户角色

    @ApiModelProperty(value = "用户名", required = false)
    @Column(name = "username")
    private String username;//用户名

    @ApiModelProperty(value = "密码", required = false)
    @Column(name = "password")
    private String password;//密码

    @ApiModelProperty(value = "邮箱", required = false)
    @Column(name = "email")
    private String email;//邮箱

    @ApiModelProperty(value = "创建时间", required = false)
    @Column(name = "create_time")
    private String create_time;//创建时间

    @ApiModelProperty(value = "修改时间", required = false)
    @Column(name = "modify_time")
    private String modify_time;//修改时间

    @ApiModelProperty(value = "已删除", required = false)
    @Column(name = "is_deleted")
    private String is_deleted;//已删除

    @ApiModelProperty(value = "已激活", required = false)
    @Column(name = "is_active")
    private String is_active;//已激活

    @ApiModelProperty(value = "令牌", required = false)
    @Column(name = "token")
    private String token;//令牌

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
