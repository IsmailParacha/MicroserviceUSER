package com.userservice.Services;

import java.util.List;

import com.userservice.Paylod.UserDto;

public interface UserServices {
    // For create
    UserDto createUser(UserDto userDto);

    // Update
    UserDto updateUser(UserDto userDto, Integer id);

    // Delete
    void deleteUser(Integer id);

    // Get Single user
    UserDto getUser(Integer id);

    // Get All Users
    List<UserDto> getAllUsers();

}
