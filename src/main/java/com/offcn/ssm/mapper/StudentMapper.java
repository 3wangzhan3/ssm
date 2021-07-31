package com.offcn.ssm.mapper;

import com.offcn.ssm.pojo.BreadCrumd;
import com.offcn.ssm.pojo.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> findAll();

    Student getOne(String id);

    void regist(Student student);

    void delete(String id);

    void update(Student student);

    Student findByUsername(String username);

    int checkUser(String username);

    List<BreadCrumd> getEntity();

    List<BreadCrumd> getEntity1();

    List<BreadCrumd> getEntity2();
}
