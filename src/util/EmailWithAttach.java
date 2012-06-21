import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailWithAttach {
  public static void main (String args[]) 
      throws Exception {
    
	//String host = args[0];
    String from = "sentmca@gmail.com";
    String to = "senthil.murugan@groupfio.com";
    String fileAttachment = "C:\\Documents and Settings\\Senthil\\Desktop\\Samplejava1.java";
    
    final String username = "sentmca@gmail.com";
	final String password = "sugasenthil";

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");



    // Get session
    Session session = Session.getInstance(props, new javax.mail.Authenticator() { 
    	protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	  });

    // Define message
    MimeMessage message = 
      new MimeMessage(session);
    message.setFrom(
      new InternetAddress(from));
    message.addRecipient(
      Message.RecipientType.TO, 
      new InternetAddress(to));
    message.setSubject("Hello JavaMail Attachment");

    // create the message part 
    MimeBodyPart messageBodyPart = 
      new MimeBodyPart();

    //fill message
    messageBodyPart.setText("Hi");

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);

    // Part two is attachment
    messageBodyPart = new MimeBodyPart();
    DataSource source =  new FileDataSource(fileAttachment);
    messageBodyPart.setDataHandler(
      new DataHandler(source));
    messageBodyPart.setFileName(fileAttachment);
    multipart.addBodyPart(messageBodyPart);

    // Put parts in message
    message.setContent(multipart);

    // Send the message
    Transport.send( message );
  }
}