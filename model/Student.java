package model;

public class Student extends Person implements IStudent {
    private String className;
    private String subject;



    public Student(int id, String name, String email, int age, String className, String subject) {
        super(id, name, email, age);
        this.className = className;
        this.subject = subject;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String getSubjectToLearn() {
        return subject;
    }

    @Override
    public void setSubjectToLearn(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + ", className: " + className + ", subject: " + subject;
    }
}
