package com.userservice.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userservice.Paylod.ApiResponse;
import com.userservice.Paylod.ContactDto;
import com.userservice.Paylod.UserDto;
import com.userservice.Services.UserServices;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserServices userServices;
    @Autowired
    private RestTemplate restTemplate;

    // POST-create user
    @PostMapping("/add/")
    public ResponseEntity<UserDto> createUser(@Validated @RequestBody UserDto userdto) {
        UserDto createUserDto = this.userServices.createUser(userdto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    // PUT-update user
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDto> updateUser(@Validated @RequestBody UserDto userdto, @PathVariable Integer id) {
        UserDto updateUser = this.userServices.updateUser(userdto, id);
        return ResponseEntity.ok(updateUser);

    }

    // DELETE-delete user
    @DeleteMapping("/deleteUser/id:{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id) {
        this.userServices.deleteUser(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }

    // GET- multiple users get
    @GetMapping("/getUsers/")
    public ResponseEntity<List<UserDto>> getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize) {
        List<UserDto> users = this.userServices.getAllUsers(pageNo, pageSize);

        return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
    }

    // GET- single user get
    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer id) {
        UserDto user = this.userServices.getUser(id);
        // Set contact = this.restTemplate.getForObject(
        // "http://localhost:8080/user/getUser/" + user.getId(),
        // Set.class);
        // user.setContact(contact);
        return ResponseEntity.ok(user);
    }

}
