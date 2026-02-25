package barker_server.application;

import org.springframework.stereotype.Service;

import barker_server.domain.in.RegisterUserUseCase;
import barker_server.domain.model.user.UserBuilder;
import barker_server.domain.model.user.User;

@Service
public class RegisterUserService implements RegisterUserUseCase {

  @Override
  public void register(String username) {

    User newUser = new UserBuilder()
        .username("annette")
        .password("pwd")
        .profilePictureUrl("url")
        .build();

    System.out.println(newUser.toString());
  }

}
