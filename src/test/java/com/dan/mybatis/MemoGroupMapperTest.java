package com.dan.mybatis;

import com.dan.mybatis.entity.MemoGroup;
import com.dan.mybatis.mapper.MemoGroupMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/6/23
 */
public class MemoGroupMapperTest {

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
    public void testQueryAllMemoGroup() {
         SqlSession sqlSession=sqlSessionFactory.openSession(true);
         MemoGroupMapper memoGroupMapper=sqlSession.getMapper(MemoGroupMapper.class);
        List< MemoGroup> effect= memoGroupMapper.queryAll();
        for (MemoGroup temp:
             effect) {
            System.out.println(temp);
        }
        sqlSession.close();
    }
@Test
    public void test_insetMemoGroup(){
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        MemoGroupMapper memoGroupMapper=sqlSession.getMapper(MemoGroupMapper.class);
        MemoGroup memoGroup=new MemoGroup();
        memoGroup.setName("dd");
        memoGroup.setCreatedTime(new Date());
        int effect=memoGroupMapper.insetMemoGroup(memoGroup);
        sqlSession.close();
        Assert.assertEquals(1,effect);
    }

@Test
    public void test_updateMemoGroup(){
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        MemoGroupMapper memoGroupMapper=sqlSession.getMapper(MemoGroupMapper.class);
        MemoGroup memoGroup=new MemoGroup();
        memoGroup.setId(6);
        memoGroup.setModifyTime(new Date());
        memoGroup.setName("Language");
        int effect=memoGroupMapper.updateMemoGroup(memoGroup);
        sqlSession.close();
        Assert.assertEquals(1,effect);
    }
    @Test
    public void testDeleteMemoGroup(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
        int effect = memoGroupMapper.deleteMemoGroup(7);
        sqlSession.close();
        Assert.assertEquals(1, effect);
    }
}
