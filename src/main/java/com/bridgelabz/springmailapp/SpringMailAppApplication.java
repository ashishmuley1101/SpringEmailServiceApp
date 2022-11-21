package com.bridgelabz.springmailapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringMailAppApplication {

	@Autowired
	private EmailSenderService emailService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMailAppApplication.class, args);
	}

	//Simple email.
//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail(){
//		emailService.sendSimpleEmail(
//				"ashishmuley1101@gmail.com",
//				"This is email body...",
//				"This is a email subject...!"
//		);
//
//	}

	//Email send with attachment.
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		emailService.sendEmailWithAttachment("ashishmuley1101@gmail.com",
				"This is Email Body with Attachment...",
				"This email has attachment",
				"C:\\Users\\admin\\Desktop\\BridgelabCFP\\images.jpg");

	}
}
