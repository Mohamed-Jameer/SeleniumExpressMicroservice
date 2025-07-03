package com.address_Service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressAppConfig {
    // So why here we create ModelMapper bean because its thrid party app so its not created by spring boot If u use Autowire it will throw. It must be done
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
