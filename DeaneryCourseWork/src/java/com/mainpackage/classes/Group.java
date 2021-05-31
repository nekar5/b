package com.mainpackage.classes;

import java.util.ArrayList;
import java.util.Objects;

public class Group {
    private String name;
    private final ArrayList<Student> students;

    public Group(String name) {
        this.name = name;
        students = new ArrayList<>();
    }
        
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void addStudent(Student student) {
        this.students.add(student);
    }
    public void deleteStudent(int ind) {
        if(ind<0 || ind>=this.students.size()) return;
        this.students.remove(ind);
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Group other = (Group) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Group{" + "name=" + name + '}';   }}
