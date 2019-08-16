package com.wlh.study.genpj.mainpj.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wulonghuai
 */
@Configuration
@MapperScan(value = {"com.wlh.study.genpj.mainpj.mapper",
        "com.wlh.study.genpj.module.mapper"})
public class MybatisConfig {
}
