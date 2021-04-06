package com.example.demo.service.impl;

import com.example.demo.dao.TeacherMapper;
import com.example.demo.dto.StudentDto;
import com.example.demo.dto.TeacherDto;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.api.TeacherService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper;
    private ModelMapper modelMapper;

    @Autowired
    public TeacherServiceImpl(TeacherMapper teacherMapper, ModelMapper modelMapper) {
        this.teacherMapper = teacherMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> entities = teacherMapper.getAllTeachers();
        return modelMapper.map(entities, TypeToken.of(List.class).getType());
    }

    @Override
    public TeacherDto getTeacherById(int id) {
        Teacher entity = teacherMapper.getTeacherById(id);
        return modelMapper.map(entity, TeacherDto.class);
    }

    @Override
    public List<StudentDto> getStudentsByTeacherId(int id) {
        List<Student> entities = teacherMapper.getStudentsByTeacherId(id);
        return modelMapper.map(entities, TypeToken.of(List.class).getType());
    }

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        Teacher teacher = modelMapper.map(teacherDto, Teacher.class);
        teacherMapper.addTeacher(teacher);
        return getTeacherById(teacher.getTeacherId());
    }

    @Override
    public void deleteTeacher(int id) {
        teacherMapper.deleteTeacherFromAllStudents(id);
        teacherMapper.deleteTeacher(id);
    }


}
