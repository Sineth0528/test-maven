package com.kushan.abclab.service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class RegisterEmailService {
	
	public void sendRegistrationEmail(String recipientEmail, String messagebody) {
		
        // Set up properties for the SMTP server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("babycarelkofficial@gmail.com", "gkqslbxrorlocqct");
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("babycarelkofficial@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Registration Successful");
            message.setText( messagebody );

            // Send the message
            Transport.send(message);

            System.out.println("Registration email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
