package wlh.study.mybatisdemo;


import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyBatisSessionUtils {

    private volatile static MyBatisSessionUtils sessionUtils = null;

    private MyBatisSessionUtils() {}

    public static MyBatisSessionUtils getInstance() {
        if (sessionUtils == null) {
            synchronized (sessionUtils) {
                if (sessionUtils == null) {
                    sessionUtils = new MyBatisSessionUtils();
                }
            }
        }
        return sessionUtils;
    }

    private static SqlSession sqlSession = null;

    private static Properties getJDBCProperties(String resourcePathAndFileName) {
        Properties prop = new Properties();
        try {
            @Cleanup InputStream propertiesFis = Resources.getResourceAsStream(resourcePathAndFileName);
            prop.load(propertiesFis);
            return prop;
        } catch (IOException e) {
            throw  new RuntimeException("getJDBCProperties: 加载配置文件出现异常");
        }
    }

    private static InputStream getMybaitsXmlConfig(String resourcePathAndFileName) {
        try {
            InputStream propertiesFis =  Resources.getResourceAsStream(resourcePathAndFileName);
            return propertiesFis;
        } catch (IOException e) {
            throw  new RuntimeException("getMybaitsXmlConfig:加载配置文件出现异常");
        }
    }

    public static SqlSession getSqlSession(String jdbcPropertiesFilePath, String xmlFilePath, String environment) throws IOException {
        Properties jdbcProperties = MyBatisSessionUtils.getJDBCProperties(jdbcPropertiesFilePath);
        @Cleanup InputStream mybaitsXmlConfig = MyBatisSessionUtils.getMybaitsXmlConfig(xmlFilePath);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybaitsXmlConfig,environment,jdbcProperties);
        return sqlSessionFactory.openSession();
    }
}
