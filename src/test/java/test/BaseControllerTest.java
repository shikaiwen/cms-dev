package test;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import cn.hutool.core.lang.Console;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/spring.xml","classpath:spring/spring-mvc.xml"})
@WebAppConfiguration
public class BaseControllerTest {

    @Resource
    WebApplicationContext wac;
    DefaultMockMvcBuilder mockBuilder = null;
    protected MockMvc mockMvc;
    
    @Before
    public void setup(){
//		MockitoAnnotations.initMocks(this);
//		MockMvcBuilders.webAppContextSetup(wac)
        mockBuilder = webAppContextSetup(wac);
//		SystemFilter sysFilter = new SystemFilter();
//		mockBuilder.addFilters( sysFilter );
        mockMvc = mockBuilder.build();
//		mockMvc = MockMvcBuilders.standaloneSetup(agentController).build();
    }
	
}
