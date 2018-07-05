package com.dan.mybatis.mapper;

import com.dan.mybatis.entity.MemoGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/6/23
 */
public interface MemoGroupMapper {

    /**
     * 查询所有便签组
     *
     * @return
     */
    List<MemoGroup> queryAll();


    /**
     * 插入一个便签组
     *
     * @param memoGroup
     * @return
     */
    int insetMemoGroup(MemoGroup memoGroup);

    /**
     * 修改便签组的名称
     */
    int updateMemoGroup(MemoGroup memoGroup);

    /**
     * 根据Id删除便签组
     *
     * @param id
     * @return
     */
    int deleteMemoGroup(int id);
}

