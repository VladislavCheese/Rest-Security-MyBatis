package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private int teacherId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String subject;
}
