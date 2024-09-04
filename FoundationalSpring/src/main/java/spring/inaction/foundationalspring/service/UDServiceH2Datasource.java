package spring.inaction.foundationalspring.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.inaction.foundationalspring.service.dto.UDDto;

/*
- UserDetailsService
- Việc kiểm tra login cần đầu tiên là kiểm tra user đó có tồn tại
- UserDetailService là một interface có abstract method là loadUserByUsername
- Có thể implement UserDetailService và viết lại logic tìm kiếm user
 */
@Service
public class UDServiceH2Datasource implements UserDetailsService {
    // có thể autowired repository ở đây để truy cập CSDL
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // tạm thời return dữ liệu tĩnh
        UDDto udDto = UDDto.builder()
                .userName("minhdc3")
                .password("")
                .build();

        if (udDto != null) {
            return udDto;
        }
        throw new UsernameNotFoundException(
                "User '" + username + "' not found");
    }
}
