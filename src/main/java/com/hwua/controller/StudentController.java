package com.hwua.controller;

import com.hwua.pojo.User;
import com.hwua.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService stuService;

    @GetMapping("/students")
    @ResponseBody
    public List<User> findAllStudents() throws Exception {
        List<User> students = stuService.findAllStudents();
        return students;
    }

    @DeleteMapping("/student/{id}")
    public String delStudentById(@PathVariable("id") Long id) throws Exception {
        stuService.delStudentById(id);
        return "redirect:/index.jsp";
    }

    @GetMapping("/student/{id}")
    public ModelAndView findStudentById(@PathVariable("id") Long id) throws Exception {
        ModelAndView mv = new ModelAndView("updateStudent");
        User stu = stuService.findStudentById(id);
        mv.addObject("stu", stu);
        return mv;
    }


    @PutMapping("/student")
    public String updateStudent(User stu) throws Exception {
        stuService.updateStudent(stu);
        return "redirect:/index.jsp";
    }

    @PostMapping("/student")
    public String addStudent(User stu) throws Exception {
        stuService.addStudent(stu);
        return "redirect:/index.jsp";
    }

}
