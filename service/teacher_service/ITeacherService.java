package service.teacher_service;
import java.util.ArrayList;
import model.Teacher;

public interface ITeacherService {
    ArrayList<Teacher> findAll();
    void addTeacher(Teacher teacher);

    void removeTeacher(int idTeacher);

    Teacher findTeacher(int idTeacher);

    void updateTeacher(int  idTeacher, Teacher updateTeacher);
}
