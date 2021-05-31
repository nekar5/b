package services;

import com.mainpackage.classes.Student;
import com.mainpackage.dao.GroupDAOimpl;
import java.util.concurrent.atomic.AtomicReference;

public class AddStudentService {
     public void service(String  groupName, Student student,AtomicReference<GroupDAOimpl> groupDAO){
        groupDAO.get().addStudent(groupName, student);
    }
}
