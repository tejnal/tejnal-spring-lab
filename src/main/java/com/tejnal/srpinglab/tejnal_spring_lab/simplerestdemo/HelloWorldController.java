package com.tejnal.srpinglab.tejnal_spring_lab.simplerestdemo;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.MessageSource;
        import org.springframework.context.i18n.LocaleContextHolder;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestHeader;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.Locale;

@RestController
// this annotation need be used when we creating RESTful api's
public class HelloWorldController {

    @Autowired private MessageSource messageSource;

    @Autowired private HelloWorld helloWorld;

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello-world";
    }

    @GetMapping("/hello-world-bean")
    public String helloWorldBean() {
        return helloWorld.setMessage("Hello-world-Bean");
    }

    @GetMapping("/hello-world-bean/{name}")
    public String helloWorldPathVariable(@PathVariable String name) {
        return helloWorld.setMessage("hello world, " +  name);

    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized() {
        return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
    }



}
