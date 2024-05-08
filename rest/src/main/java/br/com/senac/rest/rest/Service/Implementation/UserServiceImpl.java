package br.com.senac.rest.rest.Service.Implementation;

import br.com.senac.rest.rest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.senac.rest.rest.domain.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User createUser(User user)
    {
        return this.userRepository.save(user);
    }

    @Override
    public User getUserById(Long id)
    {
        Optional<User> optionalUser = this.userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<User> getAllUsers()
    {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id)
    {
        this.userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user)
    {
        User existingUser = this.userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setEmail(user.getEmail());
        existingUser.setLastName(user.getLastName());

        return this.userRepository.save(existingUser);
    }
}
