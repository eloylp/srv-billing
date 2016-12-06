package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"web", "service"})
@EnableMongoRepositories(basePackages = {"dao"})
@PropertySource("classpath:/properties/config.properties")
public class SrvBilling {

    public static void main(String[] args) {
        SpringApplication.run(SrvBilling.class, args);
    }

}
