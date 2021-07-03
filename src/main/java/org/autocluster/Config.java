package org.autocluster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config
{
    @Bean
    public BorderInterface library()
    {
        return new Library();
    }
}
