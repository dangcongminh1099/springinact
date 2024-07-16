package spring.inaction.foundationalspring.config;

import org.springframework.context.annotation.Bean;

public class ConfigurationClass1 {

    public void printConfig1(){
        System.out.println("Config 1");
    }

    @Bean
    public ConfigurationClass1 bean1(){
        return new ConfigurationClass1();
    }

}
