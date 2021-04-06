package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.TeacherDto;
import com.example.demo.service.api.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST контроллер для работы со студентами
 */

@Tag(name = "Студент", description = "API для студентов")
@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Operation(summary = "Получение списка всех студентов")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение студента по идентификатору")
    public StudentDto getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/teachers/{id}")
    @Operation(summary = "Получение всех учителей студента по идентификатору студента")
    public List<TeacherDto> getTeachersByStudentId(@PathVariable int id) {
        return studentService.getTeachersByStudentId(id);
    }

    @PostMapping
    @Operation(summary = "Добавление студента")
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }

    @PostMapping("/{studentId}/teacher/{teacherId}")
    @Operation(summary = "Приписание студента преподавателю")
    public void addStudentToTeacher(@PathVariable int studentId, @PathVariable int teacherId) {
        studentService.addStudentToTeacher(studentId,teacherId);
    }

    @DeleteMapping("/{studentId}/teacher/{teacherId}")
    @Operation(summary = "Отписание студента от преподавателя")
    public void removeStudentFromTeacher(@PathVariable int studentId, @PathVariable int teacherId){
        studentService.removeStudentFromTeacher(studentId, teacherId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление студента по идентфиикатору")
    public void deleteStudentById(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping
    @Operation(summary = "Изменение студента")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentDto);
    }
}
