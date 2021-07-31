package com.offcn.ssm.service;

import com.offcn.ssm.pojo.BreadCrumd;
import com.offcn.ssm.pojo.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student getOne(String id);

    void regist(Student student);

    void delete(String id);

    void update(Student student);

    int checkUser(String username);

    List<BreadCrumd> getBreadData(Integer id);

}
