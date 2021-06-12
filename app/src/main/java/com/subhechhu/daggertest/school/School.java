package com.subhechhu.daggertest.school;

import javax.inject.Inject;

public class School {

    private final Teacher teacher;
    private final Student student;

    @Inject
    public School(Teacher teacher, Student students) {
        this.teacher = teacher;
        this.student = students;
    }

    public String getStudentName() {
        return student.getName();
    }

    public boolean isMonitor() {
        return student.getIsClassMonitor();
    }

    public String getStudentGrades() {
        return student.getGrades();
    }

    public String getTeacherName() {
        return teacher.getName();
    }

    public String getTeacherSubject() {
        return teacher.getSubject();
    }

    public boolean isClassTeacher() {
        return teacher.isClassTeacher();
    }

    public void addStudentName(String value) {
        student.setName(value);
    }

    public void addStudentGrade(String value) {
        student.setGrades(value);
    }

    public void setMonitor(boolean value) {
        student.setIsClassMonitor(value);
    }

    public void addTeacherName(String value) {
        teacher.setName(value);
    }

    public void addTeacherSubject(String value) {
        teacher.setSubject(value);
    }

    public void setClassTeacher(boolean value) {
        teacher.setClassTeacher(value);
    }


    @Override
    public String toString() {
        return "School{" +
                "teacher=" + teacher +
                ", student=" + student +
                '}';
    }
}
