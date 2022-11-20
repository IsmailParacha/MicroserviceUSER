package com.userservice.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.userservice.Paylod.ContactDto;

import lombok.*;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String phoneNo;
    // private Set<ContactDto> contact = new HashSet<>();

}
