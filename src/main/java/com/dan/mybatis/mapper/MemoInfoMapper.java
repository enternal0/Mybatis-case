package com.dan.mybatis.mapper;

import com.dan.mybatis.common.Page;
import com.dan.mybatis.entity.MemoInfo;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author: secondriver
 * Created: 2018/6/30
 * 数据库操作
 */
public interface MemoInfoMapper {
   //插入方法
   int insertMemoInfo(MemoInfo memoInfo);
    //更新方法
    int updateMemoInfo(MemoInfo memoInfo);

    //分页查询
    //select * from memo_info limit pageSize offset (pageNumber-1)*pageSize order by columnName
    List<MemoInfo> queryByPage(
            @Param("pageSize") Integer pageSize,
            @Param("pageOffset") Integer pageOffset,
            @Param("columnName") String columnName
    );

    List<MemoInfo> queryByPageWithObject(Page page);

//    根据id查询便签信息
    MemoInfo QueryMemoInfoById(Integer id);
    //根据ID删除便签信息
    int deleteMemoInfo(Integer id);
    //   根据便签组id查询组中的便签信息
    MemoInfo QueryMemoInfoByGroupId(Integer groupId);
    //查询便签信息，根据标题，内容，创建时间   且的关系
    List<MemoInfo> queryMemoInfoByTitle(
            @Param("content") String content,
             @Param("title")  String title
    );
    //根据ID更新便签信息
      int upDataMemoInfoById(MemoInfo memoInfo);

//    查询便签信息，根据私密或提醒状态
    List<MemoInfo> queryMemoInfoByprivacyOrRemind(MemoInfo memoInfo);
//    查询符合一组编号的便签信息 参数为数组类型
    List<MemoInfo> queryMemoInfoByGroupId(Integer[] arr);

    //    查询符合一组编号的便签信息 参数为List
    List<MemoInfo> queryMemoInfoByList(List list);

    //    查询符合一组编号的便签信息 参数为Map
    List<MemoInfo> queryMempInfoByMap(Map ids);
//       分页查询便签信息
    List<MemoInfo> QueryMemoInfpByPage();
    List<MemoInfo> QueryMemoInfoByPageWithOffsetOf();
}
