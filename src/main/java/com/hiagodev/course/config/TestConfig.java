package com.hiagodev.course.config;

import com.hiagodev.course.entities.Order;
import com.hiagodev.course.entities.User;
import com.hiagodev.course.repository.OrderRepository;
import com.hiagodev.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("maria","maria@gmail.com","1191919111","122");
        User u2 = new User("mario","mario@gmail.com","11999111","133");

        Order o1 = new Order(null, Instant.parse("2019-07-20T19:54:07Z"),u1);
        Order o2 = new Order(null, Instant.parse("2019-07-20T19:58:07Z"),u1);
        Order o3 = new Order(null, Instant.parse("2019-07-21T19:57:07Z"),u2);
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
