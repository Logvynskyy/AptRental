package com.logvynskyy.aptrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class AptRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AptRentalApplication.class, args);
    }

    @Bean
    protected HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
