package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.hutool.core.lang.Console;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/spring.xml",})
public class BaseServiceTest {

    @Before
    public void setup(){
    }
    
    @Test
    public void serviceTest() {
    	Console.log("123");
    }
	
}
