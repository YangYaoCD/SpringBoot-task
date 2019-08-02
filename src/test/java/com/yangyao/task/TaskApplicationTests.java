package com.yangyao.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("还在睡觉？");
        message.setText("起来嗨");
        message.setTo("1663459634@qq.com");//643370615
        message.setFrom("1344262070@qq.com");
        mailSender.send(message);
    }
    @Test
    public void test02() throws MessagingException {
        //1.创建一个复杂消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("还在睡觉？");
        helper.setText("<b style='color:red'>起来嗨</b>",true);
        helper.setTo("1663459634@qq.com");//643370615
        helper.setFrom("1344262070@qq.com");

        //上传文件
        helper.addAttachment("1.jpg",new File("D:\\360Downloads\\323627.jpg"));
        mailSender.send(mimeMessage);
    }
}
