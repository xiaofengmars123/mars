package com.hwua.service.impl;

import com.hwua.mapper.UserMapper;
import com.hwua.pojo.User;
import com.hwua.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllStudents() throws Exception {
        return userMapper.findAllStudents();
    }

    @Override
    public User findStudentById(Long id) throws Exception {
        return userMapper.findStudentById(id);
    }

    @Override
    @Transactional
    public void delStudentById(Long id) throws Exception {
        userMapper.delStudentById(id);
    }

    @Override
    @Transactional
    public void updateStudent(User stu) throws Exception {
        userMapper.updateStudent(stu);
    }

    @Override
    @Transactional
    public void addStudent(User stu) throws Exception {
        userMapper.addStudent(stu);
    }
}
