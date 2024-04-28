package ru.gb.spring8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.spring8.aspect.LoggingAspect;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Spring8Application {

    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }

    public static void main(String[] args) {
        SpringApplication.run(Spring8Application.class, args);
    }

}
