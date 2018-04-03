package com.issoh.test.customer;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.Configuration;
import org.junit.Test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.baomidou.springmvc.mapper.system.UserMapper;
import com.issoh.entity.Customer;
import com.issoh.mapper.CustomerMapper;
import com.issoh.service.ICustomerService;

import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import test.BaseServiceTest;

public class CustomerServiceTest extends BaseServiceTest{

	@Resource ICustomerService customerService;
	
	@Test
	public void getlist() {
		EntityWrapper<Customer> wapper = new EntityWrapper<Customer>();
		List<Customer> list =  customerService.selectList(wapper);
		Console.log(JSONUtil.toJsonStr(list));
	}
	
	@Resource CustomerMapper customerMapper;
	
	@Resource UserMapper userMapper;
	
	@Test
	public void aliasList() {
//		@SuppressWarnings("rawtypes")
//		List list = session.selectList("com.issoh.mapper.CustomerMapper.aliasPageSelect", null);
//		Console.log(JSONUtil.toJsonStr(userMapper.myall()));
		List<Customer> clis = customerMapper.getCustomerForPage();
		MybatisSqlSessionFactoryBean df;
		Console.log(JSONUtil.toJsonStr(clis));
	}
	
	public static void main(String []args) {
//		
		Configuration con;
		String appid = "wx6343265628182fab";
		String secretId = "e02f900bda41fb49ec46a958a87d49b3";
		String js_code = "013m6zvJ1ZP9G40VyfuJ1F0pvJ1m6zv4";
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secretId+"&js_code="+js_code+"&grant_type=authorization_code";
		String result1 = HttpUtil.get(url);
		Console.log(result1);
	}
	
//	public byte[] decrypt(byte[] content, byte[] keyByte, byte[] ivByte) throws InvalidAlgorithmParameterException {
////	     initialize();
//	     try {
//	         Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
//	         Key sKeySpec = new SecretKeySpec(keyByte, "AES");
//	         cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte)); // 初始化
//	         byte[] result = cipher.doFinal(content);
//	         return result;
//	     } catch (NoSuchAlgorithmException e) {
//	         e.printStackTrace();  
//	     } catch (NoSuchPaddingException e) {
//	         e.printStackTrace();  
//	     } catch (InvalidKeyException e) {
//	         e.printStackTrace();
//	     } catch (IllegalBlockSizeException e) {
//	         e.printStackTrace();
//	     } catch (BadPaddingException e) {
//	         e.printStackTrace();
//	     } catch (NoSuchProviderException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	     } catch (Exception e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	     }
//	
//}

}