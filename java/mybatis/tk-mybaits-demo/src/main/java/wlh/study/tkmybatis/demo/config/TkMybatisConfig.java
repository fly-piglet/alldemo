package wlh.study.tkmybatis.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wulonghuai
 */
@Configuration
@tk.mybatis.spring.annotation.MapperScan(basePackages = "wlh.study.tkmybatis.demo.mapper")
public class TkMybatisConfig {
}
