package com.issoh.test.customer;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.issoh.entity.Customer;
import com.issoh.service.ICustomerService;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import test.BaseServiceTest;

public class CustomerServiceTest extends BaseServiceTest{

	@Resource ICustomerService customerService;
	
	@Test
	public void getlist() {
//		EntityWrapper<Customer> wapper = new EntityWrapper<Customer>();
//		List<Customer> list =  customerService.selectList(wapper);
//		Console.log(JSONUtil.toJsonStr(list));
	}
}
