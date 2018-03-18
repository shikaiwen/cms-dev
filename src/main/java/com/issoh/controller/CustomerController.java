package com.issoh.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springmvc.common.result.JsonResult;
import com.baomidou.springmvc.controller.BaseController;
import com.issoh.entity.Customer;
import com.issoh.service.ICustomerService;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.extra.mail.MailUtil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Kevin123
 * @since 2018-03-16
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController{

	@Resource ICustomerService customerService;
	
    @RequestMapping("/list")
    public ModelAndView listpage(ModelAndView mav) {
    	mav.setViewName("pages/tables/customerlist");
        return mav;
    }
	
    @RequestMapping("/list2")
    public ModelAndView listpage2(ModelAndView mav) {
    	mav.setViewName("a");
        return mav;
    }
    
    @ResponseBody
    @RequestMapping("/selectPage")
    public Object selectPage(ModelAndView mav,Page<Customer> page) {
    	Page<Customer> pageList = customerService.selectPage(page, null);
//        Page<Customer>  orderList = (Page<Customer>) provider.execute(orderparameter).getResult();
    	Object pageData = MapUtil.builder().put("rows", pageList.getRecords())
				    	.put("total", pageList.getTotal())
				    	.build();
    	JsonResult result = renderSuccess();
    	result.setObj(pageData);
//    	mav.setViewName("a");
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/addCustomer")
    public Object addCustomer(Customer customer) {
		boolean added = customerService.insert(customer);
		JsonResult result = added ? renderSuccess() : renderError();
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/sendEmail")
    public Object sendEmail(@RequestParam("email")String [] emailArr) {
    	List<String> list =  CollUtil.newArrayList(emailArr);
    	list.add("shikaiwenchina@gmail.com");
    	MailUtil.send(list, "测试", "邮件来自Kevin测试", false);
		JsonResult result = renderSuccess();
        return result;
    }
    
    
    @ResponseBody
    @RequestMapping("/getlist")
    public Object getlist() {
		EntityWrapper<Customer> wapper = new EntityWrapper<Customer>();
		List<Customer> list =  customerService.selectList(wapper);
		JsonResult result = renderSuccess();
		result.setObj(list);
        return result;
    }
}

