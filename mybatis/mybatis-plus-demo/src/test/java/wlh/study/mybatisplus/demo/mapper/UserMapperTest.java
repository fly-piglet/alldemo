package wlh.study.mybatisplus.demo.mapper;

import wlh.study.mybatisplus.demo.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList =  userMapper.selectList(null);
        assertEquals(5, userList.size());
        // 循环输出
        userList.forEach(System.out::println);
    }

    @Test
    public void testConditionSelect() {
        // 都能够使用条件进行处理，包括分页也是
    }
}