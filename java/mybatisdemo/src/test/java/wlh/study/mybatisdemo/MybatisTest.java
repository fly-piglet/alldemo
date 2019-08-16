package wlh.study.mybatisdemo;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MybatisTest {

    private SqlSession sqlSession;

    @Before
    public void setUp() {
        try {
            sqlSession = MyBatisSessionUtils.getSqlSession("test1/test.properties", "test1/mybatis.xml", "development");
        } catch (IOException e) {
            throw new RuntimeException("生成sqlSession出现异常，检查配置。");
        }
    }

    @Test
    public void testGetSession() {
        Assert.assertNotNull(sqlSession);
    }


}
