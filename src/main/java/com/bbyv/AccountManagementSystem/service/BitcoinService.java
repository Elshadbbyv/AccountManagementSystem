package com.bbyv.AccountManagementSystem.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BitcoinService {
    private final RestTemplate restTemplate;

    public BitcoinService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
