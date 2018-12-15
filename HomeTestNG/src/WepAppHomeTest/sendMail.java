package WepAppHomeTest;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class sendMail 
{
	

	

	   public static void sendingMail(String subject, String sendfilefullpath) 
	   
	   {     
	      // Recipient's email ID needs to be mentioned.
	      String to = "libisusser@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "libisusser@gmail.com";

	      // Get  properties
	      Properties props = new Properties();

	      // Setup mail server
		  final String username = "tessapicks@gmail.com";
		  final String password = "milydyrs3";
			
	      props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.host", "smtp.gmail.com");
		  props.put("mail.smtp.port", "587");

		  // get a Session instance
		  Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });


	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject(subject);

	         // Create the message part 
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Fill the message
	         messageBodyPart.setText("This is the report we got:\n");
	         
	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
			 File f = new File(sendfilefullpath);
			 String filenameOnly = f.getName();
	         DataSource source = new FileDataSource(sendfilefullpath);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filenameOnly);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart );

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
}
