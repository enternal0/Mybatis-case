package com.dan.mybatis.entity;
import com.dan.mybatis.common.BackGround;
import lombok.Data;

import java.util.Date;

/**
 * Author: secondriver
 * Created: 2018/6/30
 */
@Data
//实体类对应数据库中的表
 public class MemoInfo {
    private Integer id;
    private Integer groupId;
    private String title;
    private String content;
    private Character privacy;
    private BackGround backGround;
    private Character remind;
    private Date remindTime;
    private Date createdTime;
    private Date modifyTime;

}
