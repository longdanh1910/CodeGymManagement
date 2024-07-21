package repository.student_repo;

import model.Student;
import java.util.ArrayList;
import java.util.Scanner;


import java.time.LocalDate;

public class StudentRepository implements IStudentRepository {
    private static final ArrayList<Student> students;

    private static final Scanner sc;

    static {
        sc = new Scanner(System.in);
        students = new ArrayList<>();
    }

    @Override
    public ArrayList<Student> findAll() {
        return students;
    }


    @Override
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Thêm mới học viên thành công!");
    }

    @Override
    public void removeStudent(int idStudent) {
        students.removeIf(student -> student.getId() == idStudent);
        System.out.println("Xóa học viên thành công!");
    }

    @Override
    public Student findStudent(int idStudent) {
        for (Student student : students) {
            if (student.getId() == idStudent) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void updateStudent(int idStudent, Student updateStudent) {
        Student student = findStudent(idStudent);
        student.setName(updateStudent.getName());
        student.setAge(updateStudent.getAge());
        student.setEmail(updateStudent.getEmail());
        student.setClassName(updateStudent.getClassName());
        student.setSubjectToLearn(updateStudent.getSubjectToLearn());
        System.out.println("Thông tin học viên đã được cập nhật: " + student);

    }
}
