package example.Validator.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CustomMessageHandler {

    private static MessageSource staticMessageSource;

    @Autowired
    public CustomMessageHandler(MessageSource messageSource) {
        staticMessageSource = messageSource;
    }

    public static String getMessage(String code) {
        return staticMessageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

}
