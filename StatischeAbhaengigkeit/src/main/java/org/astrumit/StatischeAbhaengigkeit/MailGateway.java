package org.astrumit.StatischeAbhaengigkeit;
import java.security.Security;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailGateway {

	public static void notify(String string) {
	    final String username = "user";
	    final String password = "password";
	    String recipientEmail = "me@example.com";
String ccEmail = "cc@example.com";
String title = "Urgent Notfication";
String message = "Dear customer, \n You have been notified!";
	    
	        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

	        // Get a Properties object
	        Properties props = System.getProperties();
	        props.setProperty("mail.smtps.host", "smtp.gmail.com");
	        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	        props.setProperty("mail.smtp.socketFactory.fallback", "false");
	        props.setProperty("mail.smtp.port", "465");
	        props.setProperty("mail.smtp.socketFactory.port", "465");
	        props.setProperty("mail.smtps.auth", "true");

	        /*
	        If set to false, the QUIT command is sent and the connection is immediately closed. If set 
	        to true (the default), causes the transport to wait for the response to the QUIT command.

	        ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
	                http://forum.java.sun.com/thread.jspa?threadID=5205249
	                smtpsend.java - demo program from javamail
	        */
	        props.put("mail.smtps.quitwait", "false");

	        Session session = Session.getInstance(props, null);

	        try {
	        // -- Create a new message --
	        final MimeMessage msg = new MimeMessage(session);

	        // -- Set the FROM and TO fields --
	        msg.setFrom(new InternetAddress(username + "@gmail.com"));
	        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

	        if (ccEmail.length() > 0) {
	            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
	        }

	        msg.setSubject(title);
	        msg.setText(message, "utf-8");
	        msg.setSentDate(new Date());

	        Transport t = session.getTransport("smtps");

	        t.connect("smtp.gmail.com", username, password);
	        t.sendMessage(msg, msg.getAllRecipients());      
	        t.close();
	        } catch (Exception ex) {
	        	throw new RuntimeException(ex);
	        }
	    }
		
	}