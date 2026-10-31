package com.example.mockmid_practice;

import javafx.scene.control.Alert;

import java.time.LocalDate;

public class QuestionPaper {
    private String courseId, Semester, Description, qpType;
    private int year, DurationInMin;
    private float totalMark;
    private LocalDate examdate;

    public QuestionPaper(String courseId, String semester, String description, String qpType, int year, int durationInMin, float totalMark, LocalDate examdate) {
        this.courseId = courseId;
        Semester = semester;
        Description = description;
        this.qpType = qpType;
        this.year = year;
        DurationInMin = durationInMin;
        this.totalMark = totalMark;
        this.examdate = examdate;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getSemester() {
        return Semester;
    }

    public String getDescription() {
        return Description;
    }

    public String getQpType() {
        return qpType;
    }

    public int getYear() {
        return year;
    }

    public int getDurationInMin() {
        return DurationInMin;
    }

    public float getTotalMark() {
        return totalMark;
    }

    public LocalDate getExamdate() {
        return examdate;
    }

    public void setQpType(String qpType) {
        this.qpType = qpType;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDurationInMin(int durationInMin) {
        DurationInMin = durationInMin;
    }

    public void setTotalMark(float totalMark) {
        this.totalMark = totalMark;
    }

    public void setExamdate(LocalDate examdate) {
        this.examdate = examdate;
    }

    @Override
    public String toString() {
        return "QuestionPaper{" +
                "courseId='" + courseId + '\'' +
                ", Semester='" + Semester + '\'' +
                ", Description='" + Description + '\'' +
                ", qpType='" + qpType + '\'' +
                ", year=" + year +
                ", DurationInMin=" + DurationInMin +
                ", totalMark=" + totalMark +
                ", examdate=" + examdate +
                '}';
    }

    public void printExamstatus() {
        LocalDate today = LocalDate.now();
        if (examdate.isBefore(today)) {
            System.out.println("Already conducted");
        } else if (examdate.isAfter(today)) {
            System.out.println("To be conducted");
        } else {
            System.out.println("Scheduled Today");
        }
    }
}