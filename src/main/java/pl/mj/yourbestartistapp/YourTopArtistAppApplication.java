package pl.mj.yourbestartistapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@SpringBootApplication

public class YourTopArtistAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(YourTopArtistAppApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CorsFilter());
        filterRegistrationBean.setUrlPatterns(Collections.singleton("/*"));
        return filterRegistrationBean;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000/")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "PATCH", "OPTIONS")
                        .allowCredentials(true);
            }
        };
    }

}
