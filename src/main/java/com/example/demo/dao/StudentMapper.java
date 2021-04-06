package com.example.demo.dao;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    @Select("select * from students")
    List<Student> getAllStudents();

    @Select("select * from students where student_id = #{id}")
    Student getStudentById(int id);

    @Select("select t.teacher_id, first_name, last_name, patronymic, subject from teachers t\n" +
            " join students_teachers st on t.teacher_id = st.teacher_id where student_id = #{id};")
    List<Teacher> getTeachersByStudentId(int id);

    @Insert("insert into students values (#{studentId}, #{firstName}, #{lastName}, " +
            "#{faculty}, #{year})")
    @SelectKey(keyProperty = "studentId", before = true, resultType = Integer.class,
            statement = "select nextval('student_id_seq')")
    void addStudent(Student student);

    @Insert("insert into students_teachers values (#{studentId}, #{teacherId})")
    void addStudentToTeacher(int studentId, int teacherId);

    @Delete("delete from students_teachers where student_id = #{studentId} AND " +
            "teacher_id = #{teacherId}")
    void removeStudentFromTeacher(int studentId, int teacherId);

    @Delete("delete from students where student_id = #{id}")
    void deleteStudentById(int id);

    @Delete("delete from students_teachers where student_id = #{id}")
    void removeStudentFromAllTeachers(int id);

    @Update("update students set first_name = #{firstName}, last_name = #{lastName}," +
            "faculty = #{faculty}, year = #{year} where student_id = #{studentId}")
    void updateStudent(Student student);
}
