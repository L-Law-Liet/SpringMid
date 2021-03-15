package kz.sitedev.springmid.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "kz.sitedev.springmid")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "kz.sitedev.springmid.repository")
public class Config {}
