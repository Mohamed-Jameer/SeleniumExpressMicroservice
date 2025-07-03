package com.Employee_Service.config;

import org.hibernate.annotations.Bag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfig {

    @Value("${addressservice.base.url}")
    private String addressBaseURL;

    // So why here we create ModelMapper bean because its thrid party app so its not created by spring boot If u use Autowire it will throw. It must be done
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Bean
    public WebClient webClient(){
       return WebClient.builder()
               .baseUrl(addressBaseURL).build();
    }
}
