package me.dio.api_dio.domain.service.Impl;

import me.dio.api_dio.domain.model.User;
import me.dio.api_dio.domain.repository.UserRepository;
import me.dio.api_dio.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User fingById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("This User already exist.");
        }

        return userRepository.save(userToCreate);
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
