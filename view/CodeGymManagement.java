package view;

import controller.StudentController;
import controller.TeacherController;

import java.util.Scanner;

public class CodeGymManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();
        int choice;
        do {
            System.out.println("Quản lý CodeGym: \n" +
                    "1. Quản lý học viên. \n" +
                    "2. Quản lý giảng viên. \n" +
                    "3. Thoát. \n" +
                    "Nhập lựa chọn của bạn.");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> studentController.displayStudentFunctional();
                case 2 -> teacherController.displayTeacherFunctional();
                case 3 -> System.exit(1);
            }
        } while (true);


    }
}
