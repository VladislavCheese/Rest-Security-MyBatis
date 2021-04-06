package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "Модель данных учителя")
public class TeacherDto {

    @Schema(title = "Идентификатор учителя")
    private int teacherId;
    @Schema(title = "Имя учителя")
    private String firstName;
    @Schema(title = "Фамилия учителя")
    private String lastName;
    @Schema(title = "Отчество учителя")
    private String patronymic;
    @Schema(title = "Предмет")
    private String subject;

}
