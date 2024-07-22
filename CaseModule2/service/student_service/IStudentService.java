package service.student_service;
import model.Student;
import java.util.ArrayList;

public interface IStudentService {
    ArrayList<Student> findAll();
    void addStudent(Student student);

    void removeStudent(int idStudent);

    Student findStudent(int idStudent);

    void updateStudent(int  idStudent, Student updateStudent);
}
