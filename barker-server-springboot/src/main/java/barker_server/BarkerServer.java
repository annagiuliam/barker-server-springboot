package barker_server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import barker_server.domain.in.UserUseCase;

@SpringBootApplication
@EnableCaching
public class BarkerServer {

  public static void main(String[] args) {
    SpringApplication.run(BarkerServer.class, args);
  }

  // @Bean
  // CommandLineRunner run(RegisterUserUseCase registerUserUseCase) {
  // return args -> registerUserUseCase.register("annette");
  // }

}
