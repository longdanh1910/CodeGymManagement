package controller;
import java.time.LocalDate;
import java.util.Scanner;
import model.Teacher;
import service.teacher_service.ITeacherService;
import service.teacher_service.TeacherService;

import java.util.List;
public class TeacherController {
    private final ITeacherService iTeacherService = new TeacherService();
    private static int currentTeacherId = 1;
    private final Scanner sc = new Scanner(System.in);

    public void displayTeacher() {
        List<Teacher> teachers = iTeacherService.findAll();
        for(Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public void addTeacher() {
        System.out.print("Nhập tên giảng viên: ");
        String name = sc.nextLine();
        System.out.print("Nhập ngày sinh giảng viên: ");
        LocalDate birthday = LocalDate.parse(sc.nextLine());

        System.out.print("Nhập email giảng viên: ");
        String email = sc.nextLine();
        System.out.print("Nhập chức vụ của giảng viên: ");
        String level = sc.nextLine();
        System.out.print("Nhập môn giảng viên đang theo giảng: ");
        String subject = sc.nextLine();
        Teacher teacher = new Teacher(currentTeacherId++, name, email, birthday, level, subject);
        iTeacherService.addTeacher(teacher);
    }

    public void removeTeacher() {
        System.out.print("Nhập ID giảng viên cần xóa: ");
        int idTeacher = sc.nextInt();
        iTeacherService.removeTeacher(idTeacher);
        sc.nextLine();
    }

    public void updateTeacher() {
        System.out.print("Nhập ID của giảng viên cần chỉnh sửa: ");
        int id = sc.nextInt();
        sc.nextLine();
        Teacher teacher = iTeacherService.findTeacher(id);
        if(teacher == null)  {
            System.out.println("Không có giảng viên có mã số: " + id);
            return;
        }
        System.out.print("Nhập mới tên của giảng viên: ");
        String name = sc.nextLine();
        System.out.print("Nhập ngày sinh của giảng viên: ");

        LocalDate birthday = LocalDate.parse(sc.nextLine());
        System.out.print("Nhập email mới của giảng viên: ");
        String email = sc.nextLine();
        System.out.print("Nhập chức vụ mới của giảng viên: ");
        String level = sc.nextLine();
        System.out.print("Nhập môn mới của giảng viên: ");
        String subject = sc.nextLine();

        Teacher updatedTeacher = new Teacher(id, name, email, birthday, level, subject);
        iTeacherService.updateTeacher(id, updatedTeacher);
    }

    public void displayTeacherFunctional() {
        int choice;
        do {
            System.out.println("Quản lý giảng viên: \n" +
                    "1. Hiển thị danh sách giảng viên. \n" +
                    "2. Thêm mới giảng viên. \n" +
                    "3. Xóa giảng viên. \n" +
                    "4. Chỉnh sửa giảng viên. \n" +
                    "5. Trở về trang chủ. \n" +
                    "Nhập lựa chọn của bạn.");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> displayTeacher();
                case 2 -> addTeacher();
                case 3 -> removeTeacher();
                case 4 -> updateTeacher();
                case 5 -> {
                    return;
                }
            }
        } while (true);
    }
}
