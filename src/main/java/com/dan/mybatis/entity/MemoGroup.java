package com.dan.mybatis.entity;
import lombok.Data;

import java.util.Date;

/**
 * Author: secondriver
 * Created: 2018/6/23
 */
@Data
public class MemoGroup {

//写出所有字段
    private Integer id;

    private String name;

    private Date createdTime;

    private Date modifyTime;
}

