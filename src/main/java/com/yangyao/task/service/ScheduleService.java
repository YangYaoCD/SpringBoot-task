package com.yangyao.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    JavaMailSenderImpl mailSender;
    int i=0;
    /**
     * second（秒）, minute（分）, hour（时）, day of month（日）, month（月）,  day of week（周几）.
     * "0 * * * * MON-FRI"
     */
    //@Scheduled(cron ="0 * * * * MON-FRI" )
    @Scheduled(cron ="0,10,20,30,40,50 * * * * MON-FRI" )
    public void hello(){
        i++;
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject(i+"越哥还在睡觉？");
        message.setText("起来嗨");
        message.setTo("643370615@qq.com");//643370615
        message.setFrom("1344262070@qq.com");
        mailSender.send(message);
    }
}
