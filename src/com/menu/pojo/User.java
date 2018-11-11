package com.menu.pojo;

import java.io.Serializable;

/**
 * CREATE TABLE `user` (
 *   `user_id` varchar(36) NOT NULL,
 *   `username` varchar(36) NOT NULL,
 *   `password` varchar(36) NOT NULL,
 *   `user_flag` int(2) NOT NULL DEFAULT '1' COMMENT '1为用户。2为管理员',
 *   PRIMARY KEY (`user_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class User implements Serializable {

    private String userId;
    private String username;
    private String password;
    private Integer userFlag;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Integer getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Integer userFlag) {
        this.userFlag = userFlag;
    }

}
