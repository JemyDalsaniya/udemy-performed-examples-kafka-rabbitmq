package com.spring.springboot.kafka.example.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private int id;
    private String firstName;
    private String lastName;

}
