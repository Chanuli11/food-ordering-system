package com.ijse.foodsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodsystemApplication {

    private static final Logger logger = LoggerFactory.getLogger(FoodsystemApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FoodsystemApplication.class, args);
        logger.info("Food Ordering System is up and running!");
    }
}