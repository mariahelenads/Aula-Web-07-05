package br.com.senac.rest.rest.repository;
import br.com.senac.rest.rest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByEmail(String email);
}
