
package spring.inaction.foundationalspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfUrlMatch {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/h2-*/**").permitAll()
                        .antMatchers("/").authenticated() // chỉ yêu cầu request với root path
                        .anyRequest().authenticated() // yêu cầu tất cả request xác thực ngoại trừ /h2-*/**
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
