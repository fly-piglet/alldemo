package com.wlh.study.genpj.mainpj.mapper;

import com.wlh.study.genpj.Application;
import com.wlh.study.genpj.mainpj.model.Mainpj;
import com.wlh.study.genpj.mainpj.model.MainpjExample;
import com.wlh.study.genpj.module.mapper.ModuleMapper;
import com.wlh.study.genpj.module.model.Module;
import com.wlh.study.genpj.module.model.ModuleExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class MainpjMapperTest {

    @Resource
    private MainpjMapper mapper;

    @Resource
    private ModuleMapper moduleMapper;

    @Test
    public void mapperNotNumm() {
        assertNotNull(mapper);
    }

    @Transactional
    @Test
    public void testQuery() {

        String name = String.valueOf(System.currentTimeMillis());
        // 插入
        Mainpj pj = new Mainpj();
        pj.setName(name);
        mapper.insert(pj);
        // 查询
        MainpjExample mainpjExample = new MainpjExample();
        mainpjExample.createCriteria().andNameEqualTo(name);
        List<Mainpj> mainpjs = mapper.selectByExample(mainpjExample);
        assertTrue(mainpjs.size() > 0);
        // 删除
        Mainpj mainpj = mainpjs.get(0);
        int i = mapper.deleteByPrimaryKey(mainpj.getId());
        assertTrue(i > 0);
    }

    @Test
    public void testModule() {
        assertNotNull(moduleMapper);
    }
}