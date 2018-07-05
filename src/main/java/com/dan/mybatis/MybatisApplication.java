package com.dan.mybatis;

import com.dan.mybatis.entity.MemoGroup;
//import com.dan.mybatis.mapper.MemoGroupMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/6/23
 */
public class MybatisApplication {
    public static SqlSessionFactory sqlSessionFactory;

    //SqlSessionFactoryBuilder  : 为了创建一个SqlSessionFactory
    //SqlSessionFactory ： 一个应用程序，只需要一个就可以了
    //SqlSession：使用SQL操作的时候，创建一个SqlSession
    public static void buildWithXML() {

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new
                SqlSessionFactoryBuilder();
        try {
            //SqlSessionFactoryBuilder可以从xml配置文件构建出SqlSessionFactory对象
            sqlSessionFactory = sqlSessionFactoryBuilder.build(
                    Resources.getResourceAsStream("mybatis-config.xml")
            );
            //通过sqlSessionFactory.openSession()这个方法得到sqlSession对象,放在try
            // 里面自动关闭流
            try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
                //使用命令的名称 = 名命空间+"."+命令ID

                //使用Mapper接口映射 MemoGroupMapper命令空间  MemoGroup结果集名字
//                MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
//                List<MemoGroup> memoGroupList = memoGroupMapper.queryAll();
//                System.out.println(memoGroupList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static void buildWithJava() {
//        Configuration configuration = new Configuration();
//        String id = "dev";
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        DataSource dataSource = new PooledDataSource(
//                "com.mysql.jdbc.Driver",
//                "jdbc:mysql://localhost:3306/memo",
//                "root",
//                "960909"
//        );
//        Environment environment = new Environment(id, transactionFactory, dataSource);
//        configuration.setEnvironment(environment);
//        sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
//        System.out.println(sqlSessionFactory);
//    }

    public static void main(String[] args) {
//        buildWithJava();
    }
}

