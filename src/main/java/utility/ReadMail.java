package utility;

import java.util.Properties;

import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.FlagTerm;

import org.apache.log4j.Logger;

import static constants.Constants.harshadAppPass;
import static constants.Constants.harshadEmail;

public class ReadMail {

    static String otp = "";



    public static Logger log = Logger.getLogger(ReadMail.class);

    public static String fetchOTPFromGmail() {
        String otp = null;
        try {
            Thread.sleep(6000); // Wait if needed for email delivery

            Properties properties = new Properties();
            properties.put("mail.imap.host", "imap.gmail.com");
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.ssl.enable", "true");
            properties.put("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.auth", "true");

            Session session = Session.getInstance(properties);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", harshadEmail, harshadAppPass);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            for (int i = messages.length - 1; i >= 0; i--) {
                Message message = messages[i];

                String subject = message.getSubject();
                if (subject != null && subject.contains("is OTP to access DigiLocker account")) { // Change as per real subject

                    otp = subject.split(" ")[0];
                    System.out.println(otp);
                    break;
                }
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otp;
    }

//    private static String getTextFromMessage(Message message) throws Exception {
//        if (message.isMimeType("text/plain")) {
//            return message.getContent().toString();
//        } else if (message.isMimeType("multipart/*")) {
//            Multipart multipart = (Multipart) message.getContent();
//            StringBuilder result = new StringBuilder();
//            for (int i = 0; i < multipart.getCount(); i++) {
//                BodyPart part = multipart.getBodyPart(i);
//                if (part.isMimeType("text/plain")) {
//                    result.append(part.getContent().toString());
//                }
//            }
//            return result.toString();
//        }
//        return "";
//    }

}