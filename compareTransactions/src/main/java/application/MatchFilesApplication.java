package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class MatchFilesApplication {

    public static void main(String args[]) {
        SpringApplication.run(MatchFilesApplication.class, args);
    }

}
