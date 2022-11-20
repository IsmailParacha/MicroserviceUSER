package com.userservice.Paylod;

import java.util.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String phoneNo;
    private Set<ContactDto> contact = new HashSet<>();
}
