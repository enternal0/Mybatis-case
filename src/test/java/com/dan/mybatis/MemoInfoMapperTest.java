package com.dan.mybatis;

import com.dan.mybatis.common.Page;
import com.dan.mybatis.entity.MemoInfo;
import com.dan.mybatis.mapper.MemoInfoMapper;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Author: secondriver
 * Created: 2018/6/23
 */
public class MemoInfoMapperTest {

    public static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setBefore() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new
                SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = sqlSessionFactoryBuilder.build(
                    Resources.getResourceAsStream("mybatis-config.xml")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void setAfter() {
        sqlSessionFactory = null;
    }

    @Test
    //分页查询
    public void test_queryByPage() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        List<MemoInfo> memoInfoList = memoInfoMapper.queryByPage(2, 0, "created_time");
        for (MemoInfo memoInfo : memoInfoList) {
            System.out.println(memoInfo);
        }
        sqlSession.close();
    }

    @Test
//    分页查询
    public void test_queryByPageWithObject() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        Page page = new Page();
        page.setPageSize(2);
        page.setPageNumber(1);
        page.setOrderColumnName("created_time");
        List<MemoInfo> memoInfoList = memoInfoMapper.queryByPageWithObject(page);
        for (MemoInfo memoInfo : memoInfoList) {
            System.out.println(memoInfo);
        }
        sqlSession.close();
    }

    @Test
    //更新便签信息
    public void test_updateMemoInfo() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = new MemoInfo();
        memoInfo.setId(2);
        memoInfo.setTitle("JDBC");
        memoInfo.setPrivacy('1');
        memoInfo.setContent("JDBC is great");
        int effect = memoInfoMapper.updateMemoInfo(memoInfo);
        sqlSession.close();
//        断言一下，看结果是否一样
        Assert.assertEquals(1, effect);
    }

    @Test
    public void test_InsertMemoInfo() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = new MemoInfo();
        memoInfo.setContent("English is great");
        memoInfo.setTitle("English");
        memoInfo.setGroupId(0);
        memoInfo.setPrivacy('1');
        memoInfo.setCreatedTime(new Date());
        int effect = memoInfoMapper.insertMemoInfo(memoInfo);
        sqlSession.close();
        Assert.assertEquals(1, effect);
    }

    @Test
//根据ID查询memo_Info信息
    public void test_QueryMemoInfoById() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo effect = memoInfoMapper.QueryMemoInfoById(5);
        sqlSession.close();
        System.out.println(effect);
    }

    @Test
    //根据id删除memo_Info信息
    public void test_deleteMemoInfo() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        int effect = memoInfoMapper.deleteMemoInfo(5);
        sqlSession.close();
        Assert.assertEquals(1, effect);
    }

    @Test
//   根据便签组id查询组中的便签信息
    public void testQueryMemoInfoByGroupId() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = memoInfoMapper.QueryMemoInfoByGroupId(0);
        sqlSession.close();
        System.out.println(memoInfo);
    }

    @Test
    //查询便签信息，根据标题，内容，创建时间   且的关系
    public void testqueryMemoInfoByTitle() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        List<MemoInfo> memoInfo = memoInfoMapper.queryMemoInfoByTitle("I Love English", "English");
        sqlSession.close();
        System.out.println(memoInfo);
    }

    @Test
    public void test_upDataMemoInfoById() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = new MemoInfo();
        memoInfo.setId(3);
        memoInfo.setTitle("NJDBC");
        memoInfo.setPrivacy('1');
        memoInfo.setContent("It Is NJDBC");
        int effect = memoInfoMapper.upDataMemoInfoById(memoInfo);
        sqlSession.close();
        Assert.assertEquals(1, effect);
    }

    @Test
    public void test_queryMemoInfoByprivacyOrRemind() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = new MemoInfo();
        memoInfo.setPrivacy('1');
        memoInfo.setRemind('0');
        List<MemoInfo> effect = memoInfoMapper.queryMemoInfoByprivacyOrRemind(memoInfo);
        for (MemoInfo temp :
                effect) {
            System.out.println(effect);
        }
        sqlSession.close();
    }

    @Test
    public void test_queryMemoInfoByInteger() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        List<MemoInfo> effect = memoInfoMapper.queryMemoInfoByGroupId(new Integer[]{1, 2, 3});
        for (MemoInfo temp : effect) {
            System.out.println(temp);
        }
        sqlSession.close();
    }

    @Test
    public void test_QueryMemoInfpByPage() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        PageHelper.startPage(2, 2);
        List<MemoInfo> effect = memoInfoMapper.QueryMemoInfpByPage();
        for (MemoInfo temp : effect) {
            System.out.println(temp);
        }
        sqlSession.close();
    }

    @Test
    public void test_QueryMemoInfoByPageWithOffsetOf() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        Long effect = PageHelper.count(new ISelect() {
            @Override
            public void doSelect() {
                memoInfoMapper.QueryMemoInfoByPageWithOffsetOf();
            }
        });
        sqlSession.close();
        //返回数据库此时还有几条记录
        System.out.println(effect);
//        PageHelper.offsetPage(1, 2);
//        List<MemoInfo> effect = memoInfoMapper.QueryMemoInfoByPageWithOffsetOf();
//        sqlSession.close();
//        for (MemoInfo temp:effect){
//            System.out.println(temp);
//        }
    }
@Test
    public void test_queryMemoInfoByList() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(6);
        List<MemoInfo> effect = memoInfoMapper.queryMemoInfoByList(list);
        sqlSession.close();
        for (MemoInfo temp:effect) {
            System.out.println(temp);
        }
    }
@Test
    public void test_queryMempInfoByMap(){
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper=sqlSession.getMapper(MemoInfoMapper.class);
        Map map=new HashMap<>();
        map.put("ids",new Integer[]{2,3});
        List<MemoInfo> effect=memoInfoMapper.queryMempInfoByMap(map);
        sqlSession.close();
        System.out.println(effect);
    }
}

