package com.mahesh.fetchivo.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService {
    private static final Logger log = LoggerFactory.getLogger(MyService.class);
    int i  =100;

    public void showMsg(){
        log.error("Zerooooo");
    }
}
