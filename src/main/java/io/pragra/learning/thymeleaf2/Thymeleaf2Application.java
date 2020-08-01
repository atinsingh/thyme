package io.pragra.learning.thymeleaf2;

import io.pragra.learning.thymeleaf2.domain.Blog;
import io.pragra.learning.thymeleaf2.service.BlogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Thymeleaf2Application {

    private BlogService service;

    public Thymeleaf2Application(BlogService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(Thymeleaf2Application.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            service.createBlog(new Blog(1L, "Java", "","Java is a good"));
            service.createBlog(new Blog(2L, "Angular", "","Angular is a good"));
        };
    }
}
