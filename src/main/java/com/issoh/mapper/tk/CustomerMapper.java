package com.issoh.mapper.tk;

import java.util.List;

import com.issoh.entity.tk.Customer;

import tk.mybatis.mapper.common.Mapper;

public interface CustomerMapper extends Mapper<Customer> {
	public List<Customer> getCustomerForPage();
}