package com.tejnal.srpinglab.tejnal_spring_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;


@SpringBootApplication
public class TejnalSpringLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(TejnalSpringLabApplication.class, args);
    }

    @Bean
   public LocaleResolver localResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;

    }

}
