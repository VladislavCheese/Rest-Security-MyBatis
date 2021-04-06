package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "Модель данных студента")
public class StudentDto {

    @Schema(title = "Идентификатор студента")
    int studentId;
    @Schema(title = "Имя студента")
    String firstName;
    @Schema(title = "Фамилия студента")
    String lastName;
    @Schema(title = "Факультет")
    String faculty;
    @Schema(title = "Курс")
    int year;
}
