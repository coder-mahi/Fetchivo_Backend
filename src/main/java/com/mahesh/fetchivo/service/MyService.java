package com.mahesh.fetchivo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    public void doSomething() {
        logger.info("INFO log: Doing something");
        logger.debug("DEBUG log: Details...");
        logger.error("ERROR log: Something went wrong");
    }
}
