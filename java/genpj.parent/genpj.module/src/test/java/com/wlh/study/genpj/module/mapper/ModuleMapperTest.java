package com.wlh.study.genpj.module.mapper;

import com.wlh.study.genpj.module.model.Module;
import com.wlh.study.genpj.module.model.ModuleExample;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class ModuleMapperTest extends BaseMybatisTest {

    private ModuleMapper mapper;

    @Before
    public void init() {
        mapper = getSession().getMapper(ModuleMapper.class);
    }

    @Test
    public void name() {
        Assert.assertNotNull(mapper);
    }

    @Test
    public void testInsert() {
        Module module = new Module();
        String name = String.valueOf(System.currentTimeMillis());
        module.setName(name);
        int insert = mapper.insert(module);
        Assert.assertTrue(insert > 0);

        ModuleExample moduleExample = new ModuleExample();
        moduleExample.createCriteria().andNameEqualTo(name);
        List<Module> modules = mapper.selectByExample(moduleExample);
        Assert.assertTrue(modules.size() == 1);
    }

}