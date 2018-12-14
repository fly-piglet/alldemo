package wlh.study.tkmybatis.demo.model.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author wulonghuai
 */
@Data
public class User {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private String email;
}