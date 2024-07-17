
package spring.inaction.foundationalspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfInMemoryUsrStore {

    // [In-memory user store]: cấu hình config security lưu thông tin người dùng vào bộ nhớ tạm
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        String encoded = new BCryptPasswordEncoder().encode("123");
//        // phải khai báo prefix ở đầu để biết dùng encode gì
//        UserDetails userA = User.withUsername("minhdc")
//                .password("{bcrypt}"+encoded)
//                .roles("USER")
//                .build();
//
//        // user này không encode password (mặc định các bản spring cao cần encode nhưng có thể bypass bằng cách đặt prefĩx {noop})
//        UserDetails userB = User.withUsername("minhdc3")
//                .password("{noop}123")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(userA,userB);
//    }
}
