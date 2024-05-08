package br.com.senac.rest.rest.Service.Implementation;

import br.com.senac.rest.rest.domain.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void deleteUser(Long id);

    User updateUser(User user);
}
