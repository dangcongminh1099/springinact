package spring.inaction.foundationalspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.inaction.foundationalspring.config.ConfigurationClass1;

@SpringBootApplication
public class FoundationalSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoundationalSpringApplication.class, args);
    }

}
