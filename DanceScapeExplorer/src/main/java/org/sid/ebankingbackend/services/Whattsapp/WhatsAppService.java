package org.sid.ebankingbackend.services.Whattsapp;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppService {/*

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.whatsapp.from}")
    private String fromWhatsAppNumber;

    private static final String COUNTRY_CODE = "+216";

    public void sendWhatsAppMessage(String toWhatsAppNumber, String messageBody) {
        Twilio.init(accountSid, authToken);

        //String fullPhoneNumber = COUNTRY_CODE + toWhatsAppNumber;

        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + toWhatsAppNumber),
                new PhoneNumber(fromWhatsAppNumber),
                messageBody
        ).create();

        System.out.println("Message WhatsApp envoyé. SID: " + message.getSid());
    }*/
}

