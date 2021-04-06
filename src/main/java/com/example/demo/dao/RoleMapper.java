package com.example.demo.dao;

import com.example.demo.auth.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleMapper {

    @Select("select * from roles where role_id = #{id}")
    Role getRoleById(int id);

}
