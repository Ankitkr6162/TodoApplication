package com.ankit.spring.ankit.mvc.listener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyListenerConfig {

    @Bean
    public ServletListenerRegistrationBean<MyListener> myListener() {
        ServletListenerRegistrationBean<MyListener> listenerBean =
                new ServletListenerRegistrationBean<>();
        listenerBean.setListener(new MyListener());
        return listenerBean;
    }
}

