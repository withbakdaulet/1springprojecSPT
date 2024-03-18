package kz.bitlab.springboot.springproject.models;

import java.util.ArrayList;

public class DBmanager {
    public static ArrayList<Student> students = new ArrayList<>();
    public static Long id = 6L;

    static {
        students.add(new Student(1L,"Bakdaulet","Assan",95,"A"));
        students.add(new Student(2L,"Zhanbolat","Qasym",50,"D"));
        students.add(new Student(3L,"Ramazan","Tanat",73,"B"));
        students.add(new Student(4L,"Erasyl","Torekhan",55,"C"));
        students.add(new Student(5L,"Dias","Otebay",48,"E"));
    }

    public static ArrayList<Student> getStudent(){
        return students;
    }

    public static void addStudent(Student student){
        student.setId(id);
        if(student.getExam()>90){
            student.setMark("A");
        } else if (student.getExam()>75 && student.getExam()<90) {
            student.setMark("B");
        }else if (student.getExam()>60 && student.getExam()<75) {
            student.setMark("C");
        }else if (student.getExam()>50 && student.getExam()<60) {
            student.setMark("D");
        }else{
            student.setMark("Error");
        }
        students.add(student);
        id++;
    }
    public static Student addStudent(Long idbek){
        return students.stream().filter(student -> student.getId()==idbek).findFirst().orElseThrow();
    }
}
