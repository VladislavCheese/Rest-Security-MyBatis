package com.example.demo.service.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.dto.StudentDto;
import com.example.demo.dto.TeacherDto;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.api.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;
    private ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper, ModelMapper modelMapper) {
        this.studentMapper = studentMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> entities = studentMapper.getAllStudents();
        return modelMapper.map(entities, TypeToken.of(List.class).getType());
    }

    @Override
    public StudentDto getStudentById(int id) {
        Student entity = studentMapper.getStudentById(id);
        return modelMapper.map(entity, StudentDto.class);
    }

    @Override
    public List<TeacherDto> getTeachersByStudentId(int id) {
        List<Teacher> entities = studentMapper.getTeachersByStudentId(id);
        return modelMapper.map(entities, TypeToken.of(List.class).getType());
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student entity = modelMapper.map(studentDto, Student.class);
        studentMapper.addStudent(entity);
        return getStudentById(entity.getStudentId());
    }

    @Override
    public void addStudentToTeacher(int studentId, int teacherId) {
        studentMapper.addStudentToTeacher(studentId, teacherId);
    }

    @Override
    public void removeStudentFromTeacher(int studentId, int teacherId) {
        studentMapper.removeStudentFromTeacher(studentId, teacherId);
    }

    @Override
    public void deleteStudentById(int id) {
        studentMapper.removeStudentFromAllTeachers(id);
        studentMapper.deleteStudentById(id);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        studentMapper.updateStudent(student);
        return getStudentById(student.getStudentId());
    }
}
