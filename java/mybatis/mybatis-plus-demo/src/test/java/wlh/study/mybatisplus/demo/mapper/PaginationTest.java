package wlh.study.mybatisplus.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import wlh.study.mybatisplus.demo.model.MyPage;
import wlh.study.mybatisplus.demo.model.ParamSome;
import wlh.study.mybatisplus.demo.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wulonghuai
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaginationTest {
    @Resource
    private UserMapper mapper;

    @Test
    public void tests() {
        System.out.println("----- baseMapper 自带分页 ------");
        Page<User> page = new Page<>(1, 5);
        IPage<User> userIPage = mapper.selectPage(page, new QueryWrapper<User>()
                .eq("age", 20).eq("name", "Jack"));
        Assert.assertSame(page, userIPage);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        print(userIPage.getRecords());
        System.out.println("----- baseMapper 自带分页 ------");



        System.out.println("----- 自定义 XML 分页 ------");
        MyPage<User> myPage = new MyPage<User>(1, 5).setSelectInt(20).setSelectStr("Jack");
        ParamSome paramSome = new ParamSome(20, "Jack");
        MyPage<User> userMyPage = mapper.mySelectPage(myPage, paramSome);
        Assert.assertSame(myPage, userMyPage);
        System.out.println("总条数 ------> " + userMyPage.getTotal());
        System.out.println("当前页数 ------> " + userMyPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userMyPage.getSize());
        print(userMyPage.getRecords());
        System.out.println("----- 自定义 XML 分页 ------");
    }

    private <T> void print(List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(System.out::println);
        }
    }
}
