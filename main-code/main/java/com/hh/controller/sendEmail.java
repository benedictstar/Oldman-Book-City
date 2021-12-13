package com.hh.controller;

import com.hh.entity.User;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class sendEmail {
    public void sendEmail(User user){
        //配置各种配置
        System.out.println(user.getEmail());
        Properties props=new Properties();
        props.setProperty("mail.host","smtp.qq.com");
        props.setProperty("mail.smtp.auth","true");
        props.put("mail.smtp.port", "587");
        //qq邮箱的ssl加密
//        MailSSLSocketFactory sf= null;
//        try {
//            sf = new MailSSLSocketFactory();
//        } catch (GeneralSecurityException e) {
//            e.printStackTrace();
//        }
//        sf.setTrustAllHosts(true);
//            props.put("mail.smtp.ssl.enable","true");
//            props.put("mail.smtp.ssl.socketFactory",sf);
            //authentication参数，登录邮箱
            Authenticator authenticator=new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("1179090198@qq.com","iiubcqekyszwjece");
                }
            };
            Session session=Session.getDefaultInstance(props,authenticator);

            Message message=new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress("1179090198@qq.com"));
                message.setRecipient(Message.RecipientType.TO,new InternetAddress(user.getEmail()));
                message.setSubject("老夫子二手书城");
                String mes="恭喜您，在老夫子二手书城购买成功";
                message.setContent(mes,"text/html;charset=UTF-8");
                Transport.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }

    }
}
