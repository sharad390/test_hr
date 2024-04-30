package com.lcwd;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//Get current date
import java.time.LocalDate;


public class App {
	public static void main(String[] args) {
		
		System.out.println("preparing to send message ...");
		String message = "Hi Team, \n\nPlease find attachment along with mail\n\n\n\n\n\n\n\n--\nThanks & Regards,\nSharad k";
		
		String subject = "HRMS Test Reports_" + getCurrentTime();
		String to = "sharadkamble8899@gmail.com";
		//String to = "abhayvideoranade@gmail.com";
		//String to = "supriya.boraste@Kriosispl.in";
		
		//String to = "sharad.kamble@Kriosispl.com";
		
		String from = "sharadkamble8899@gmail.com";
		
//		sendEmail(message,subject,to,from);
		sendAttach(message,subject,to,from);
	}

	//this is responsible to send the message with attachment
	private static void sendAttach(String message, String subject, String to, String from) {

		//Variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("sharadkamble8899@gmail.com", "incezcwqxcrgvarf");
			}
			
			
			
		});
		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//attachement..
		
		//file path
		//String path="C:\\Users\\DELL\\Pictures\\Screenshots\\Screenshot (4).png";
		//String path="D:\\Projects\\HRMS\\DevOps.png";
		
		//String path="D:\\Sharad\\Python\\HRMS\\hrms\\TestReports\\AutomationExtentReport_2024-04-23-055107.html";
		String path="D:\\Sharad\\Python\\HRMS\\hrms\\TestReports\\AutomationExtentReport_2024-04-26-025655.html";
				
		// Get the current date
		LocalDate currentDate = LocalDate.now();

        // Display the current date
        System.out.println("Current Date: " + currentDate);
		
		
		
		MimeMultipart mimeMultipart = new MimeMultipart();
		//text
		//file
		
		MimeBodyPart textMime = new MimeBodyPart();
		
		MimeBodyPart fileMime = new MimeBodyPart();
		
		try {
			
			textMime.setText(message);
			
			File file=new File(path);
			fileMime.attachFile(file);
			
			
			mimeMultipart.addBodyPart(textMime);
			mimeMultipart.addBodyPart(fileMime);
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		m.setContent(mimeMultipart);
		
		
		//send 
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	
		System.out.println("Sent success...................");
		
		
	}

	//this is responsible to send email..
	private static void sendEmail(String message, String subject, String to, String from) {
		
		//Variable for mail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		//properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("sharadkamble8899@gmail.com", "incezcwqxcrgvarf");
			}
			
			
			
		});
		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//adding text to message
		m.setText(message);
		
		//send 
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		System.out.println("Sent success...................");
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	
	public static String getCurrentTime() 
	{
		String currentDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
		//String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		return currentDate;
	}
	
	
	
	
	
}