package com.mainpackage.dao;

import com.mainpackage.classes.Group;
import com.mainpackage.classes.Student;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GroupDAOimpl implements GroupDAO {
    private final ArrayList<Group> groups;
    
    public GroupDAOimpl() {
        groups = new ArrayList<>();
    }
    @Override
    public void addGroup(Group group) {
        if(!groups.contains(group)) groups.add(group);
        groups.forEach(System.out::println);
    }

    @Override
    public void deleteGroup(String name) {
        for(int i =0;i<groups.size();i++) {
            if(groups.get(i).getName().equals(name)) {groups.remove(i); break;}
        }
    }

    @Override
    public Group getGroup(String name) {
        for(int i =0;i<groups.size();i++) {
            if(groups.get(i).getName().equals(name)) return groups.get(i);
        }
        throw new NoSuchElementException("Не існує такої групи");
    }

    @Override
    public void addStudent(String groupName, Student student) {
        Group group = getGroup(groupName);
        group.addStudent(student);
    }

    @Override
    public void deleteStudent(String groupName, int ind) {
        Group group = getGroup(groupName);
        group.deleteStudent(ind-1);
    }

    @Override
    public ArrayList<Group> getGroups() {
        return groups;
    }

    @Override
    public ArrayList<Student> getStudents(Group group) {
        return group.getStudents();
    }

    @Override
    public ArrayList<Group> searchByGroupName(String name) {
                ArrayList<Group> searchResult = new ArrayList<>();
        for(Group group:groups) {
            if(group.getName().equalsIgnoreCase(name)) searchResult.add(group);
        }
        return searchResult;
    }

    @Override
    public ArrayList<Group> searchByStudentSurname(String surname) {
                        ArrayList<Group> searchResult = new ArrayList<>();
        for(Group group:groups) {
            for(Student student: group.getStudents()) {
                if(student.getSurname().equalsIgnoreCase(surname)) {searchResult.add(group); break;}
            }
        }
        return searchResult;
    }    
}
