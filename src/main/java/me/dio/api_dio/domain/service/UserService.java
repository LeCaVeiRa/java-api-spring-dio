package me.dio.api_dio.domain.service;

import me.dio.api_dio.domain.model.User;

public interface UserService {
    User fingById(Long id);

    User create(User userToCreate);
}
