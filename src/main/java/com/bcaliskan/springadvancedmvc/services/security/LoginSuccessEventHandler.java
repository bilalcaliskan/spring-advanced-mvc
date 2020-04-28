package com.bcaliskan.springadvancedmvc.services.security;

import com.bcaliskan.springadvancedmvc.domain.User;
import com.bcaliskan.springadvancedmvc.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginSuccessEventHandler implements ApplicationListener<LoginSuccessEvent> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        Authentication authentication = (Authentication) event.getSource();
        log.info("LoginEvent Success for: {}", authentication.getPrincipal());
        updateUserAccount(authentication);
    }

    public void updateUserAccount(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByUserName(userDetails.getUsername());
        if (user != null) { //user found
            user.setFailedLoginAttempts(0);
            log.info("Login succeeded, resetting failed attempts for user {} as 0", user.getUsername());
            userService.saveOrUpdate(user);
        }
    }

}