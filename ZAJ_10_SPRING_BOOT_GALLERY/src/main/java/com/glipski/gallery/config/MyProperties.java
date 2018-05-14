package com.glipski.gallery.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties("my")
public class MyProperties {
    @Getter
    @Setter
    private String picturesPath;
    @Getter
    @Setter
    private String serializationFilePath;
}


