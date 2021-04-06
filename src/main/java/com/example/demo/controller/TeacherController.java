package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.TeacherDto;
import com.example.demo.service.api.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST контроллер для работы с учителями
 */

@Tag(name = "Учитель", description = "API для учителей ")
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    @Operation(summary = "Получение списка всех учителей")
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение учителя по идентификатору")
    public TeacherDto getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/teacher/{id}")
    @Operation(summary = "Получение студентов учителя по идентификатору учителя")
    public List<StudentDto> getStudentsByTeacherId(@PathVariable int id) {
        return teacherService.getStudentsByTeacherId(id);
    }

    @PostMapping
    @Operation(summary = "Добавление учителя")
    public TeacherDto addTeacher(@RequestBody TeacherDto teacherDto) {
        return teacherService.addTeacher(teacherDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление учителя")
    public void deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
    }
}
