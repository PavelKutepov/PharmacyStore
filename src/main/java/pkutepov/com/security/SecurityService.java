package pkutepov.com.security;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

    String findLoggedLogin();

    void autoLogin(String login, String password);
}
