package com.mainpackage.dao;

import com.mainpackage.classes.Group;
import com.mainpackage.classes.Student;
import java.util.ArrayList;

public interface GroupDAO {
    public void addGroup(Group group);
    public void deleteGroup(String name);
    public Group getGroup(String name);
    public void addStudent(String groupName, Student student);
    public void deleteStudent(String groupName, int ind);
    public ArrayList<Group> getGroups();
    public ArrayList<Student> getStudents(Group group);
    public ArrayList<Group> searchByGroupName(String name);
    public ArrayList<Group> searchByStudentSurname(String surname);
}
