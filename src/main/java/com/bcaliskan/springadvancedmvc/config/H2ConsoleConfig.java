package com.bcaliskan.springadvancedmvc.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.h2.server.web.WebServlet;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean h2Console() {
        final String path = "/h2-console";
        final String urlMapping =  path + "/*";
        return new ServletRegistrationBean(new WebServlet(), urlMapping);
    }

}