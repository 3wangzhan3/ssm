package com.offcn.ssm.service.impl;

import com.offcn.ssm.mapper.StudentMapper;
import com.offcn.ssm.pojo.BreadCrumd;
import com.offcn.ssm.pojo.Student;
import com.offcn.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public Student getOne(String id) {
        return studentMapper.getOne(id);
    }

    @Override
    public void regist(Student student) {
        studentMapper.regist(student);
    }

    @Override
    public void delete(String id) {
        studentMapper.delete(id);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public int checkUser(String username) {
        return studentMapper.checkUser(username);
    }

    @Override
    public List<BreadCrumd> getBreadData(Integer id) {
        List<BreadCrumd> list =null;
        if (id==0){
            list =studentMapper.getEntity();
        }else if (id==1){
            list = studentMapper.getEntity1();
        }else {
            list = studentMapper.getEntity2();
        }
        return list;
    }

}
