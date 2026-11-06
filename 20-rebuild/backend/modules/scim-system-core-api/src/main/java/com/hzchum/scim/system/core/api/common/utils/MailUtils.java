package com.hzchum.scim.system.core.api.common.utils;

import com.hzchum.pangu.common.exception.BusinessException;
import java.io.File;
import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtils {
   @Value("${spring.mail.username}")
   private String fromEmail;
   @Resource
   private JavaMailSender mailSender;
   private static final String MAIL_SEND_FAIL = "邮件发送失败";

   public String commonMail(String toEmail, String subject, String text) {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom(this.fromEmail);
      message.setTo(toEmail);
      message.setSubject(subject);
      message.setText(text);
      this.mailSender.send(message);
      return "ok";
   }

   public String htmlMail(String toEmail, String subject, String html) {
      MimeMessage message = this.mailSender.createMimeMessage();

      try {
         MimeMessageHelper helper = new MimeMessageHelper(message, true);
         helper.setFrom(this.fromEmail);
         helper.setTo(toEmail);
         helper.setSubject(subject);
         helper.setText(html, true);
         this.mailSender.send(message);
         return "ok";
      } catch (Exception e) {
         throw new BusinessException("邮件发送失败");
      }
   }

   public String pictureMail(String toEmail, String subject, String filePath) {
      MimeMessage message = this.mailSender.createMimeMessage();

      try {
         MimeMessageHelper helper = new MimeMessageHelper(message, true);
         helper.setFrom(this.fromEmail);
         helper.setTo(toEmail);
         helper.setSubject(subject);
         helper.setText("<h1>发送带图片的HTML</h1><img src='cid:aaaa'/>", true);
         FileSystemResource img = new FileSystemResource(new File(filePath));
         helper.addInline("aaaa", img);
         this.mailSender.send(message);
         return "ok";
      } catch (Exception e) {
         throw new BusinessException("邮件发送失败");
      }
   }

   public String attachmentMail(String toEmail, String subject, String text, String filePath) {
      MimeMessage message = this.mailSender.createMimeMessage();

      try {
         MimeMessageHelper helper = new MimeMessageHelper(message, true);
         helper.setFrom(this.fromEmail);
         helper.setTo(toEmail);
         helper.setSubject(subject);
         helper.setText(text);
         FileSystemResource attachment = new FileSystemResource(new File(filePath));
         helper.addAttachment(attachment.getFilename(), attachment);
         this.mailSender.send(message);
         return "ok";
      } catch (Exception e) {
         throw new BusinessException("邮件发送失败");
      }
   }
}
