package com.wlh.study.genpj.module.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.IOException;
import java.io.InputStream;

/**
 * 通用的mybatis继承类，这边编写了加载配置，提供了获取容器配置的方法
 * @author wulonghuai
 */
public class BaseMybatisTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void initDataBase() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        // 使用jdk的日志
        LogFactory.useJdkLogging();
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    protected SqlSession getSession() {
        return sessionFactory.openSession();
    }
}
