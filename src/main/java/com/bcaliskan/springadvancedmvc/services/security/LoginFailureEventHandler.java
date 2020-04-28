package com.bcaliskan.springadvancedmvc.services.security;

import com.bcaliskan.springadvancedmvc.domain.User;
import com.bcaliskan.springadvancedmvc.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginFailureEventHandler implements ApplicationListener<LoginFailureEvent> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(LoginFailureEvent event) {
        Authentication authentication = (Authentication) event.getSource();
        log.error("LoginEvent failure for: {}", authentication.getPrincipal());
        updateUserAccount(authentication);
    }

    public void updateUserAccount(Authentication authentication){
        final User user = userService.findByUserName((String) authentication.getPrincipal());
        if (user != null) { //user found
            user.setFailedLoginAttempts(user.getFailedLoginAttempts() + 1);
            if (user.getFailedLoginAttempts() > 5)
                user.setEnabled(false);
            log.error("Failed login attempt, setting failedLoginAttempts for user {} as {}", user.getUsername(),
                    user.getFailedLoginAttempts());
            userService.saveOrUpdate(user);
        }
    }

}