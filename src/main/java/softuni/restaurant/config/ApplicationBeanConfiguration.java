package softuni.restaurant.config;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.cloudinary.Cloudinary;

@Configuration
public class ApplicationBeanConfiguration {
    private final CloudinaryConfig cloudinaryConfig;

    public ApplicationBeanConfiguration(CloudinaryConfig cloudinaryConfig) {
        this.cloudinaryConfig = cloudinaryConfig;
    }

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    Cloudinary cloudinary() {
        return new Cloudinary(
                Map.of(
                        "cloud_name", cloudinaryConfig.getCloudName(),
                        "api_key", cloudinaryConfig.getApiKey(),
                        "api_secret", cloudinaryConfig.getApiSecret()
                )
        );
    }

    @Bean
    SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("user@gmail.com");
        message.setFrom("admin@gmail.com");
        message.setSubject("Important email");
        message.setText("FATAL - Application crash. Save your job !!");
        return message;
    }

    @Bean
    LocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setCookieName("lang");
        return cookieLocaleResolver;
    }

    @Bean
    LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
