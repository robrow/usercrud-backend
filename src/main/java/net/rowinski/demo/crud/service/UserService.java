package net.rowinski.demo.crud.service;

import lombok.RequiredArgsConstructor;
import net.rowinski.demo.crud.model.User;
import net.rowinski.demo.crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User update(User user) {
        return repository.save(user);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
