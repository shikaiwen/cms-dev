package com.issoh.test.customer;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import test.BaseControllerTest;


/**
 * 导出数据相关 bootstrap table https://www.cnblogs.com/wlandwl/p/bootstrap_table.html
 * @author shikw
 *
 */
/**
 * 
 * gmail发送邮件blog
 * 代码：https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
 * 设置gmail的服务
 * https://support.google.com/mail/answer/7104828?hl=ja&visit_id=0-636569316247389594-2438628430&rd=3
 * 只需要设置 ステップ 2: POP を設定する，メール転送と POP/IMAP tab， 打开开启pop服务，保存
 * 谷歌会发送一封确定邮件到当前邮箱和你设置 的备用邮箱，确定开启就可以了，2018-03-18 10:41测试完成
 * 
 * 
 * 邮件内容详解：http://blog.csdn.net/xietansheng/article/details/51673073
 * 
 * https://stackoverflow.com/questions/15796530/what-is-the-difference-between-ports-465-and-587
 */

public class CustomerControllerTest extends BaseControllerTest{

	static final String username = "shikaiwenchina@gmail.com";
	static final String password = "shikaiwen666666";
	
	static final String email_from = "shikaiwenchina@gmail.com";
	static final String email_to = "googlevsbing@126.com";
	public static void main(String[] args) {
		mailTest();
//		sendWithTssl();
//		sendWithSSL();
//		sendWithNetEasy();
	}
	
	public static void sendWithTssl() {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("shikaiwenchina@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("googlevsbing@126.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public static void sendWithSSL() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,password);
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email_from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email_to));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 虽然没有说明，通过测试，网易126只能通过ssl链接，非加密方式连不上
	 */
	public static void sendWithNetEasy() {
		MailAccount account = new MailAccount();
		account.setHost("smtp.126.com");
//		account.setPort(465);
		account.setAuth(true);
		account.setStartttlsEnable(true);
		
		account.setFrom("googlevsbing@126.com");
		account.setUser("googlevsbing@126.com");
		account.setPass("shikaiwen666666");
		
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
		
		account.setDebug(true);
//		MailUtil.send("hutool@foxmail.com", "测试", "邮件来自Hutool测试", false);
		MailUtil.send(account, CollUtil.newArrayList("googlevsbing@126.com"), "测试", "邮件来自Hutool测试", false);
	}
	
//	@Test
	public static void mailTest() {
		MailAccount account = new MailAccount();
		account.setHost("smtp.gmail.com");
		account.setPort(465);
		account.setAuth(true);
		account.setStartttlsEnable(true);
		
		account.setFrom("shikaiwenchina@gmail.com");
		account.setUser("shikaiwenchina@gmail.com");
		account.setPass("shikaiwen666666");
		
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
		
		account.setDebug(false);
//		MailUtil.send("hutool@foxmail.com", "测试", "邮件来自Hutool测试", false);
		MailUtil.send(CollUtil.newArrayList("googlevsbing@126.com"), "测试", "邮件来自Hutool测试", false);
	}
	
	
	@Test
	public void selectPage() {
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/customer/selectPage");
        builder.param("birthday", "2018-01-01") 
                .param("size", "5")
                .param("current", "2")
                .param("address", "東京都品川区");
        ResultActions re = null;
		try {
			re = mockMvc.perform(builder);
			re.andDo(print() );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void addCustomer() {
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/customer/addCustomer");
        builder.param("birthday", "2018-01-01") 
                .param("name", "浅田真央")
                .param("size", "5")
                .param("current", "1")
                .param("address", "東京都品川区");
        ResultActions re = null;
		try {
			re = mockMvc.perform(builder);
			re.andDo(print() );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getlistTest() {
		Console.log("ok");
		
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/customer/getlist");
        builder.param("orderId", "1") 
                .param("orderType", "1");
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
