package wlh.study.tkmybatis.demo.mapper;

import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import wlh.study.tkmybatis.demo.model.entity.User;

/**
 * @author wulonghuai
 */
public interface UserMapper extends Mapper<User> {

    @Select("select * from user where name = #{name}")
    User selectByName(String name);

    User selectByNameXML(String name);
}
