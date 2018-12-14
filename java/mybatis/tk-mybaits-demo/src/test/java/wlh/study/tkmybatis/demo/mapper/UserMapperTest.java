package wlh.study.tkmybatis.demo.mapper;

import com.github.pagehelper.PageHelper;
import net.bytebuddy.build.ToStringPlugin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wlh.study.tkmybatis.demo.model.entity.User;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectAll() {
        System.out.println("-------开始查询-------");
        List<User> users = userMapper.selectAll();
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByName() {
        User jone = userMapper.selectByName("Jone");
        assertNotNull(jone);
    }

    @Test
    public void name() {
        User jone = userMapper.selectByNameXML("Jone");
        assertNotNull(jone);
    }

    @Test
    public void testPage() {
        PageHelper.startPage(0, 1);
        List<User> users = userMapper.selectAll();
    }
}
