package com.example.client_service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call")
    public String callService() {
        List<ServiceInstance> instances = discoveryClient.getInstances("HELLO-SERVICE");

        if (instances == null || instances.isEmpty()) {
            return "No instances found for hello-service";
        }

        ServiceInstance randomInstance = instances.get(new Random().nextInt(instances.size()));
        String url = randomInstance.getUri().toString() + "/hello";

        String response = restTemplate.getForObject(url, String.class);
        return "Client called -> " + response;
    }
}