package com.example.demo.dao;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {

    @Select("select * from teachers")
    List<Teacher> getAllTeachers();

    @Select("select teacher_id, first_name, last_name, patronymic, subject from teachers " +
            "where teacher_id = #{teacherId}")
    Teacher getTeacherById(int id);

    @Select("select s.student_id, first_name, last_name, faculty, year from students s " +
            "join students_teachers st on s.student_id = st.student_id " +
            "where teacher_id = #{id}")
    List<Student> getStudentsByTeacherId(int id);

    @Insert("insert into teachers values (#{teacherId}, #{firstName}, #{lastName}, " +
            "#{patronymic}, #{subject})")
    @SelectKey(keyProperty = "teacherId", before = true, resultType = Integer.class,
            statement = "select nextval('teacher_id_seq')")
    void addTeacher(Teacher teacher);

    @Delete("delete from teachers where teacher_id = #{id}")
    void deleteTeacher(int id);

    @Delete("delete from students_teachers where teacher_id = #{id}")
    void deleteTeacherFromAllStudents(int id);
}
