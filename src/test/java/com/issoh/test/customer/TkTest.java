package com.issoh.test.customer;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.issoh.mapper.tk.CustomerMapper;
import com.issoh.mapper.tk.SysUserMapper;

import cn.hutool.core.lang.Console;
import test.BaseServiceTest;

public class TkTest extends BaseServiceTest{
	
	@Resource SysUserMapper userMapper;
	@Resource CustomerMapper customerMapper;
	
	
	@Test
	public void testCustomer() {
		Console.log(JSON.toJSON(customerMapper.getCustomerForPage()));
	}
	
	@Test
	public void testUser() {
		Console.log(JSON.toJSON(userMapper.selectAll()));
	}

}
