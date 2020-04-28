package com.bcaliskan.springadvancedmvc.services.security;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoginAspect {

    private LoginFailureEventPublisher failureEventPublisher;
    private LoginSuccessEventPublisher successEventPublisher;

    @Autowired
    public void setFailureEventPublisher(LoginFailureEventPublisher failureEventPublisher) {
        this.failureEventPublisher = failureEventPublisher;
    }

    @Autowired
    public void setSuccessEventPublisher(LoginSuccessEventPublisher successEventPublisher) {
        this.successEventPublisher = successEventPublisher;
    }

    @Pointcut("execution(* org.springframework.security.authentication.AuthenticationProvider.authenticate(..))")
    public void doAuthenticate(){

    }

    // args(authentication) is going to bind Authentication object on the method signature to the method
    @Before("com.bcaliskan.springadvancedmvc.services.security.LoginAspect.doAuthenticate() && args(authentication)")
    public void logBeforeExecution(Authentication authentication){
        log.info("This is before the Authenticate Method: authentication: {}", authentication.isAuthenticated());
    }

    // It will fetch the Authentication object returned from org.springframework.security.authentication.AuthenticationProvider.authenticate method
    // See line 19
    @AfterReturning(value = "com.bcaliskan.springadvancedmvc.services.security.LoginAspect.doAuthenticate()",
            returning = "authentication")
    public void logAfterAuthenticate(Authentication authentication){
        log.info("This is after the Authenticate Method authentication: {}", authentication.isAuthenticated());
        /*
        Below line will publish an LoginFailureEvent custom event to Spring event system. Listener will catch that event
        and will do something with that event.
        Published custom events will go through separate threads and we dont need to worry about it anymore. The class who
        publishing the event does not need to know, nor care about the event.
        */
        successEventPublisher.publish(new LoginSuccessEvent(authentication));
    }

    // args(authentication) is going to bind Authentication object on the method signature to the method
    @AfterThrowing("com.bcaliskan.springadvancedmvc.services.security.LoginAspect.doAuthenticate() && args(authentication)")
    public void logAuthenicationException(Authentication authentication){
        String userDetails = (String) authentication.getPrincipal();
        log.error("Login failed for user: {}", userDetails);
        /*
        Below line will publish an LoginFailureEvent custom event to Spring event system. Listener will catch that event
        and will do something with that event.
        Published custom events will go through separate threads and we dont need to worry about it anymore. The class who
        publishing the event does not need to know, nor care about the event.
        */
        failureEventPublisher.publish(new LoginFailureEvent(authentication));
    }
}