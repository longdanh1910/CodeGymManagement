package repository.student_repo;

import model.Student;


import java.util.ArrayList;

public interface IStudentRepository {
    ArrayList<Student> findAll();

    void addStudent(Student student);
    void removeStudent(int idStudent);

    Student findStudent(int idStudent);

    void updateStudent(int idStudent, Student student);
}
