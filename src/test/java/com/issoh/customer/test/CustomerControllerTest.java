package com.issoh.customer.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import cn.hutool.core.lang.Console;
import test.BaseControllerTest;


/**
 * 导出数据相关 bootstrap table https://www.cnblogs.com/wlandwl/p/bootstrap_table.html
 * @author shikw
 *
 */

public class CustomerControllerTest extends BaseControllerTest{

	@Test
	public void getlistTest() {
		Console.log("ok");
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/remote/querySuccessPhoneOrder");
        builder.param("orderId", "1") 
                .param("orderType", "1")
                .param("force", "true");
        ResultActions re = null;
		try {
			re = mockMvc.perform(builder);
		} catch (Exception e) {
			e.printStackTrace();
		}
        try {
			re.andDo(print() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
