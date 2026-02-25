package barker_server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import barker_server.domain.in.RegisterUserUseCase;

@SpringBootApplication
public class BarkerServer {

  public static void main(String[] args) {
    SpringApplication.run(BarkerServer.class, args);
  }

  @Bean
  CommandLineRunner run(RegisterUserUseCase registerUserUseCase) {
    return args -> registerUserUseCase.register("annette");
  }

}
