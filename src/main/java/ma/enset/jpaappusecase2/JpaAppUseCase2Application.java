package ma.enset.jpaappusecase2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaAppUseCase2Application {

    public static void main(String[] args) {
        SpringApplication.run(JpaAppUseCase2Application.class, args);
    }
    @Bean
    CommandLineRunner start(){
        return args -> {

        };
    }

}
