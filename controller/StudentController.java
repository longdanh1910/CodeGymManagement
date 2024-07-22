package controller;

import model.Student;
import repository.student_repo.IStudentRepository;
import service.student_service.IStudentService;
import service.student_service.StudentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final IStudentService iStudentService = new StudentService();
    private static int currentStudentId = 1;
    private final Scanner sc = new Scanner(System.in);

    public void displayStudent() {
        List<Student> students = iStudentService.findAll();
        for(Student student : students) {
            System.out.println(student);
        }
    }

    public void addStudent() {
        System.out.print("Nhập tên học viên: ");
        String name = sc.nextLine();
        System.out.print("Nhập ngày sinh học viên: ");

        LocalDate birthday=LocalDate.parse(sc.nextLine());
        System.out.print("Nhập email học viên: ");
        String email = sc.nextLine();
        System.out.print("Nhập lớp của học viên: ");
        String className = sc.nextLine();
        System.out.print("Nhập môn học viên đang theo học: ");
        String subject = sc.nextLine();
        Student student = new Student(currentStudentId++, name, email, birthday, className, subject);
        iStudentService.addStudent(student);
    }

    public void removeStudent() {
        System.out.print("Nhập ID học viên cần xóa: ");
        int idStudent = sc.nextInt();
        iStudentService.removeStudent(idStudent);
        sc.nextLine();
    }

    public void updateStudent() {
        System.out.print("Nhập ID của học viên cần chỉnh sửa: ");
        int id = sc.nextInt();
        sc.nextLine();
        Student student = iStudentService.findStudent(id);
        if(student == null)  {
            System.out.println("Không có học viên có mã số: " + id);
            return;
        }
        System.out.print("Nhập mới tên của học viên: ");
        String name = sc.nextLine();
        System.out.print("Nhập ngày sinh của học viên: ");
        LocalDate birthday = LocalDate.parse(sc.nextLine());
        System.out.print("Nhập email mới của học viên: ");
        String email = sc.nextLine();
        System.out.print("Nhập lớp mới của học viên: ");
        String className = sc.nextLine();
        System.out.print("Nhập môn mới của học viên: ");
        String subject = sc.nextLine();

        Student updatedStudent = new Student(id, name, email, birthday, className, subject);
        iStudentService.updateStudent(id, updatedStudent);
    }

    public void displayStudentFunctional() {
        int choice;
        do {
            System.out.println("Quản lý học viên: \n" +
                    "1. Hiển thị danh sách học viên. \n" +
                    "2. Thêm mới học viên. \n" +
                    "3. Xóa học viên. \n" +
                    "4. Chỉnh sửa học viên. \n" +
                    "5. Trở về trang chủ. \n" +
                    "Nhập lựa chọn của bạn.");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> displayStudent();
                case 2 -> addStudent();
                case 3 -> removeStudent();
                case 4 -> updateStudent();
                case 5 -> {
                    return;
                }
            }
        } while (true);
    }
}