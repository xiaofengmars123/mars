package com.hwua.mapper;

import com.hwua.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAllStudents() throws Exception;
    public User findStudentById(Long id) throws  Exception;
    public void delStudentById(Long id) throws Exception;
    public void updateStudent(User stu) throws Exception;
    public void addStudent(User stu) throws Exception;
}
