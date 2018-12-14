package wlh.study.springboot.demo;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wulonghuai
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueTest {

    @Value("${spirngboot.demo.value}")
    private String value;

    @Test
    public void testValueExist() {
        System.out.println(value);
        assertNotNull(value);
    }
}
