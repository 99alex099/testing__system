package by.devincubator.dits.services.admin.admininterfaces.impl;

import by.devincubator.dits.services.admin.admininterfaces.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private JavaMailSender javaMailSender;

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String fullName, String email) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Подтверждение аккаунта");
        message.setText("Добрый день, " + fullName + ". Ваш аккаунт подтвержден.\n" +
                "Это письмо отправлено автоматически, отвечать на него не нужно.\n\n" +
                "С уважением,\nКоманда Dev Incubator.");

        this.javaMailSender.send(message);

    }
}
