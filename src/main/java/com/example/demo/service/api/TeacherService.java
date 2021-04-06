package com.example.demo.service.api;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.TeacherDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> getAllTeachers();

    TeacherDto getTeacherById(int id);

    List<StudentDto> getStudentsByTeacherId(int id);

    TeacherDto addTeacher(TeacherDto teacherDto);

    void deleteTeacher(int id);
}
