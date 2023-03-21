package com.alex;

import com.alex.model.entity.Invoice;
import com.alex.repository.InvoiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) { SpringApplication.run(Main.class, args);}

    @Bean
    CommandLineRunner atStartup(InvoiceRepository repo) {
        return args -> {
            repo.save(new Invoice("test1", 100, 123));
            repo.save(new Invoice("test2", 200, 1234));
            repo.save(new Invoice("test3", 300, 12345));

        };
    }
}
