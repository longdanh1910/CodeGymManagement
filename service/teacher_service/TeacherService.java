package service.teacher_service;

import model.Teacher;

import java.util.ArrayList;

import repository.teacher_repo.ITeacherRepository;
import repository.teacher_repo.TeacherRepository;

public class TeacherService implements ITeacherService {

    private final ITeacherRepository iTeacherRepository = new TeacherRepository();

    @Override
    public ArrayList<Teacher> findAll() {
        return iTeacherRepository.findAll();
    }


    @Override
    public void addTeacher(Teacher teacher) {
        iTeacherRepository.addTeacher(teacher);
    }

    @Override
    public void removeTeacher(int idTeacher) {
        iTeacherRepository.removeTeacher(idTeacher);
    }

    @Override
    public Teacher findTeacher(int idTeacher) {
        return iTeacherRepository.findTeacher(idTeacher);
    }

    @Override
    public void updateTeacher(int idTeacher, Teacher updateTeacher) {
        iTeacherRepository.updateTeacher(idTeacher, updateTeacher);
    }


}
