package com.example.demo.service.api;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.TeacherDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(int id);

    List<TeacherDto> getTeachersByStudentId(int id);

    StudentDto addStudent(StudentDto studentDto);

    void addStudentToTeacher(int studentId, int teacherId);

    void removeStudentFromTeacher(int studentId, int teacherId);

    void deleteStudentById(int id);

    StudentDto updateStudent(StudentDto studentDto);
}
