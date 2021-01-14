package com.study.spring.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {
    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(50)
                .setMaxConnPerRoute(10)
                .build();
        httpComponentsClientHttpRequestFactory.setHttpClient(httpClient);
        httpComponentsClientHttpRequestFactory.setConnectionRequestTimeout(3000);
        httpComponentsClientHttpRequestFactory.setReadTimeout(5000);
        return new RestTemplate(httpComponentsClientHttpRequestFactory);
    }
}
