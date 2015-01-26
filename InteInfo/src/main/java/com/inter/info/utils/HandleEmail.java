package com.inter.info.utils;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;

import com.inter.info.utils.info.HandleEmailInfo;


public class HandleEmail {

	private static final Logger logger = Logger.getLogger(HandleEmail.class);

	public void Send(String Host, String[] FromAddress, String[] ToAddress, String Subject, String Content,
			String[] FileAddress) {

		//SendMail mail = new SendMail();
		HandleEmailInfo mailInfo = new HandleEmailInfo();

		// 设置邮件服务器，这里暂时用126邮箱服务器,拓展的话以后可以用上面的形参Host配置
		// mailInfo.setHost(Host);
		mailInfo.setHost("smtp.126.com");
		// 设置邮件发件人，这里的发件人也是固定的，拓展的话可以用上面的形参FromAddress配置
		mailInfo.setFromAddress("servicemessage@126.com");
		mailInfo.setUsername("servicemessage@126.com");
		mailInfo.setPassword("zhujie1392352985");

		// mailInfo.setFromAddress(FromAddress[0]); 发件人地址
		// mailInfo.setUsername(FromAddress[0]); 发件人姓名
		// mailInfo.setPassword(FromAddress[1]); 发件人密码

		// 设置为是否校验
		mailInfo.setValidate("true");
		// 设置邮件主题
		mailInfo.setSubject(Subject);
		// 设置邮件内容
		mailInfo.setContent(Content);
		// 设置邮件接收者，当收件人大于0的时候发给收件人，当收件人小于或等于0，发给服务器邮件
		if (ToAddress.length > 0) {
			mailInfo.setSendAddress(ToAddress);
		} else {
			ToAddress[0] = "servicemessage@126.com";
			mailInfo.setSendAddress(ToAddress);
		}
		if (FileAddress != null && FileAddress.length > 0) {
			mailInfo.setFilepath(FileAddress);
		}
		try {
			boolean flag = this.Send(mailInfo);
			if (flag == true) {
				logger.info(mailInfo.getSubject() + ":发送成功");
			} else {
				logger.info(mailInfo.getSubject() + ":发送失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	private boolean Send(HandleEmailInfo mailInfo) throws Exception {
		Properties props = new Properties();
		// 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
		props.put("mail.smtp.host", mailInfo.getHost());
		// 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
		props.put("mail.smtp.auth", mailInfo.getValidate());
		// 用刚刚设置好的props对象构建一个session
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(mailInfo.getFromAddress()));
			InternetAddress[] sendTo = new InternetAddress[mailInfo.getSendAddress().length];
			for (int i = 0; i < mailInfo.getSendAddress().length; i++) {
				sendTo[i] = new InternetAddress(mailInfo.getSendAddress()[i]);
			}
			message.setRecipients(Message.RecipientType.TO, sendTo);
			message.setSubject(mailInfo.getSubject());
			message.setSentDate(mailInfo.getSentdate());

			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setText(mailInfo.getContent());
			multipart.addBodyPart(contentPart);

			// 添加附件,当有附件的数量大于0的时候才能添加
			if (mailInfo.getFilepath() != null && mailInfo.getFilepath().length > 0) {
				for (int i = 0; i < mailInfo.getFilepath().length; i++) {
					BodyPart messageBodyPart = new MimeBodyPart();
					String fpath = mailInfo.getFilepath()[i].split(",")[0];
					File tempFile = new File(fpath);
					if (tempFile.exists()) {
						DataSource source = new FileDataSource(fpath);
						messageBodyPart.setDataHandler(new DataHandler(source));
						messageBodyPart.setFileName(MimeUtility.encodeText(tempFile.getName(), "UTF-8", "B"));
						multipart.addBodyPart(messageBodyPart);
					} else {
						logger.info("Can't find file : " + fpath);
					}

				}
			}
			message.setContent(multipart, "text/html;charset=UTF-8");
			message.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(mailInfo.getHost(), mailInfo.getUsername(), mailInfo.getPassword());
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e);
			return false;
		}

	}
}
