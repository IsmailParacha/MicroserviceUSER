package com.userservice.ImplementedServices;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.userservice.Entity.User;
import com.userservice.Paylod.UserDto;
import com.userservice.Repository.UserRepo;
import com.userservice.Services.UserServices;

@Service
public class UserimplServices implements UserServices {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User userData = this.modelMapper.map(userDto, User.class);
        User savedUser = this.userRepo.save(userData);
        return this.modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userdto, Integer id) {
        User user = this.userRepo.findById(id).orElseThrow(null);
        user.setName(userdto.getName());
        user.setPhoneNo(userdto.getPhoneNo());
        User updatedUser = this.userRepo.save(user);
        UserDto userDto1 = this.modelMapper.map(updatedUser, UserDto.class);
        return userDto1;
    }

    @Override
    public void deleteUser(Integer id) {
        User user = this.userRepo.findById(id).orElseThrow(null);
        this.userRepo.delete(user);

    }

    @Override
    public UserDto getUser(Integer id) {
        User user = this.userRepo.findById(id).orElse(null);
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers(Integer pageNo, Integer pageSize) {
        Pageable page = PageRequest.of(pageNo, pageSize);
        Page<User> pageusers = this.userRepo.findAll(page);
        List<User> users = pageusers.getContent();
        List<UserDto> userDtos = users.stream().map(user -> this.modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
        return userDtos;
    }

}
