package com.example.controller;

import com.example.dao.StudentDAO;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping(value = "/")  //ana sayfa view sayfası
    public ModelAndView listStudent(ModelAndView model) {
        List<Student> listStudent = studentDAO.list();
        model.addObject("listStudent", listStudent);
        model.setViewName("index");

        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET) //yeni kullanıcı oluşturma view sayfası
    public ModelAndView newStudent(ModelAndView model) {
        Student newStudent = new Student();
        model.addObject("student", newStudent);
        model.setViewName("student_newform");

        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST) //kullanıcı kaydetme requesti
    public ModelAndView saveStudent(@ModelAttribute Student student) {
        if(student.getStudent_id() == null)
        studentDAO.save(student);
        else studentDAO.update(student);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET) //kullanıcı editleme view sayfası
    public ModelAndView editStudent(HttpServletRequest request) {
        Integer student_id = Integer.parseInt(request.getParameter("student_id"));
        Student student = studentDAO.get(student_id);

        ModelAndView model = new ModelAndView("student_form");

        model.addObject("student", student);

        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET) //kullanıcı silme requesti
    public ModelAndView deleteStudent(@RequestParam Integer student_id) {
        studentDAO.delete(student_id);

        return new ModelAndView("redirect:/");
    }
 }
