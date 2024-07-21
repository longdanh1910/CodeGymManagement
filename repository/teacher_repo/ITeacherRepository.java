package repository.teacher_repo;

import java.util.ArrayList;
import model.Teacher;

public interface ITeacherRepository {
    ArrayList<Teacher> findAll();

    void addTeacher(Teacher teacher);
    void removeTeacher(int idTeacher);

    Teacher findTeacher(int idTeacher);

    void updateTeacher(int idTeacher, Teacher teacher);
}
