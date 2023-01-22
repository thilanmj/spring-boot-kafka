package com.codexmo.firstservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long ID = 1L;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}