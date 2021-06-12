package com.subhechhu.daggertest.school;

public class Teacher {

    private String subject;
    private String name;
    private boolean isClassTeacher;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isClassTeacher() {
        return isClassTeacher;
    }

    public void setClassTeacher(boolean classTeacher) {
        isClassTeacher = classTeacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", isClassTeacher=" + isClassTeacher +
                '}';
    }
}
