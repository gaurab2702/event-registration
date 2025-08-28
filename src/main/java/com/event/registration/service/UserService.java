package com.event.registration.service;

import com.event.registration.dto.response.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO findById(Long id);

    UserDTO findByUsername(String username);

    List<UserDTO> findAll();
}
