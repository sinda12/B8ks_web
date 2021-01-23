package com.esprit.b8ks_web;

import com.esprit.b8ks_web.controllers.UserController;
import com.esprit.b8ks_web.entities.User;
import com.esprit.b8ks_web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class B8ksWebApplication {



    public static void main(String[] args) {

        SpringApplication.run(B8ksWebApplication.class, args);


    }
@Bean
    CommandLineRunner start(UserController userService) {
        return args -> {

            User user1 = new User(null,24,"fellah","monji","ariena","monji@gmail.com","0101010101",false);
            User user2 = new User(null,30,"bourguiba","aziz","soukra","azizbourguiba.ab@gmail.com","0202020202",true);
            User user3 = new User(null,40,"forci","ezzedin","aouina","ezzedin@gmail.com","0303030303",false);
User user4 = new User();
user4.setAge(100);
user4.setId(3);
            userService.add(user1);
            userService.add(user2);
            userService.add(user3);
            userService.modify(user4);
        };
    }
}
