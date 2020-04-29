package com.bcaliskan.springadvancedmvc.services.security;

import com.bcaliskan.springadvancedmvc.domain.User;
import com.bcaliskan.springadvancedmvc.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Scheduled(fixedRate = 60000) // every 1 minute
    public void resetFailedLogins() {
        log.info("Checking for locked accounts...");
        List<User> userList = (List<User>) userService.listAll();
        userList.forEach(user -> {
            if (!user.getEnabled() && user.getFailedLoginAttempts() > 0) {
                log.info("Resetting failed attempts and setting enabled for user: {}", user.getUsername());
                user.setFailedLoginAttempts(0);
                user.setEnabled(true);
                userService.saveOrUpdate(user);
            }
        });
    }

}