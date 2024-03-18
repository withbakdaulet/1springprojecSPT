package kz.bitlab.springboot.springproject.controller;

import kz.bitlab.springboot.springproject.models.DBmanager;
import kz.bitlab.springboot.springproject.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<Student> students =  DBmanager.getStudent();
        model.addAttribute("students",students);
        return "index";
    }
    @GetMapping(value = "/addStudent")
    public String addStudent(){
        System.out.println("this is get");
        return "addStudent";
    }
    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestParam("student_name") String name,
                             @RequestParam("student_surname") String surname,
                             @RequestParam("student_exam") int exam , Model model){
        System.out.println("this is");
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        // Добавляем студента в базу данных
        DBmanager.addStudent(student);

        // Возвращаемся на главную страницу
        return "redirect:/";
    }

}
