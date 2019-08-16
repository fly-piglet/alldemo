package wlh.study.mybatisplus.demo.model.entity;

import lombok.Data;

/**
 * @author wulonghuai
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}